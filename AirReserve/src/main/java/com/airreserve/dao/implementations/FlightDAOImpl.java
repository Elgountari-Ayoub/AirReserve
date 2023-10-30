package com.airreserve.dao.implementations;

import com.airreserve.Entities.Flight;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.interfaces.FlightDAO;
import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FlightDAOImpl implements FlightDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Flight create(Flight flight) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            return flight;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while registering: " + e.getMessage());
        }
    }

    @Override
    public Flight getFlightById(int flightId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Flight.class, flightId);
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching flight by ID: " + e.getMessage());
        }
    }

    @Override
    public void deleteFlight(Flight flight) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(flight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while deleting flight: " + e.getMessage());
        }
    }

    @Override
    public List<Flight> getFlights() {
        List<Flight> flights;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Flight order by id ASC ";
            flights = session.createQuery(hql, Flight.class).list();

            transaction.commit();
        } catch (HibernateException e) {
            throw new PersistenceException("Error while fetching flights: " + e.getMessage());
        }
        return flights;
    }



    @Override
    public void update(Flight flight) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(flight); // Use update() method to update the flight entity
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while updating flight: " + e.getMessage());
        }
    }

}
