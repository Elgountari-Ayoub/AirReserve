package com.airreserve.dao.implementations;

import com.airreserve.Entities.Admin;
import com.airreserve.Entities.Company;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.interfaces.AdminDAO;
import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AdminDAOImpl implements AdminDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Admin create(Admin admin) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        }catch (HibernateException he){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while saving the admin entity: " + he.getMessage());

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Admin getAdminById(int id){
        Admin admin;
        try (Session session = sessionFactory.openSession()) {
            admin =  session.get(Admin.class, id);
        } catch (HibernateException e) {
            throw new PersistenceException("Error while getting the company by ID: " + e.getMessage());
        }
        return admin;
    }
}