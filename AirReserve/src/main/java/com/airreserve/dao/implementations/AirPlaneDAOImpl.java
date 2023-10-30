package com.airreserve.dao.implementations;

import com.airreserve.Entities.AirPlane;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.interfaces.AirPlaneDAO;
import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AirPlaneDAOImpl implements AirPlaneDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private AirPlane airPlane;

    @Override
    public AirPlane create(AirPlane airPlane) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(airPlane);
            transaction.commit();
            return airPlane;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while registering: " + e.getMessage());
        }
    }
    @Override
    public AirPlane getAirPlaneById(int id) {
        airPlane = new AirPlane();
        try (Session session = sessionFactory.openSession()) {
            return session.get(AirPlane.class, id);
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching airPlane by ID: " + e.getMessage());
        }
    }
    @Override
    public List<AirPlane> getAirPlanes() {
        List<AirPlane> airPlanes;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "FROM AirPlane order by id ASC ";
            airPlanes = session.createQuery(hql, AirPlane.class).list();

            transaction.commit();
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching flights: " + e.getMessage());
        }
        return airPlanes;
    }
}
