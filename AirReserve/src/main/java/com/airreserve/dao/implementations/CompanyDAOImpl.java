package com.airreserve.dao.implementations;

import com.airreserve.Entities.Company;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.interfaces.CompanyDAO;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CompanyDAOImpl implements CompanyDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Company create (Company company) throws PersistenceException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
            return company;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new PersistenceException("Error while registering: " + e.getMessage());
        }
    }
    @Override
    public Company getCompanyById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Company.class, id);
        } catch (HibernateException e) {
            throw new PersistenceException("Error while getting the company by ID: " + e.getMessage());
        }
    }

    @Override
    public List<Company> getCompaniesByName(String name){
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = builder.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);

            query.select(root).where(builder.like(root.get("name"), "%" + name + "%"));

            return session.createQuery(query).list();
        }
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Company";
            companies = session.createQuery(hql, Company.class).list();

            transaction.commit();
        }
        return companies;
    }
}
