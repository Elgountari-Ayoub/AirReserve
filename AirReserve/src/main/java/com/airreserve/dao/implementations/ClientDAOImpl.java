package com.airreserve.dao.implementations;

import com.airreserve.Entities.Client;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.interfaces.ClientDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.PersistenceException;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Client register(Client client) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
            return client;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while registering: " + e.getMessage());
        }
    }

    @Override
    public Client login(String email, String password) throws PersistenceException {
        try (Session session = sessionFactory.openSession()) {
            return (Client) session.createQuery("FROM Client WHERE email = :email AND password = :password")
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .uniqueResult();
        } catch (HibernateException e) {
            throw new PersistenceException("Error while logging in: " + e.getMessage());
        }
    }

    @Override
    public Client get(int id) throws PersistenceException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching: " + e.getMessage());
        }
    }

    @Override
    public List<Client> getAll() throws PersistenceException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching: " + e.getMessage());
        }
    }

    @Override
    public void update(Client client) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while updating: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while deleting: " + e.getMessage());
        }
    }
}
