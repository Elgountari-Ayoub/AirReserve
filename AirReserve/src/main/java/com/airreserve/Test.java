package com.airreserve;

import com.airreserve.Entities.Client;
import com.airreserve.Entities.Company;
import com.airreserve.Utils.HibernateUtil;
import com.airreserve.dao.implementations.CompanyDAOImpl;
import com.airreserve.dao.interfaces.CompanyDAO;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;

public class Test {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAOImpl();
        System.out.println("1111111111111");
        List<Company> companies = companyDAO.getCompaniesByName("Tra");
        for (Company company : companies) {
            System.out.println(company.getName());
        }
        System.out.println("222222222222");
    }

    public static Client registerClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
