package com.airreserve.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil(){
//        this.sessionFactory = null;
    }
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
                System.out.println("session created successfully");
            }
            catch (Exception e) {
                System.out.println("something went wrong while creating session factory");
                System.out.println(e.getMessage());
                StandardServiceRegistryBuilder.destroy( registry );
            }
        }
        return sessionFactory;
    }
}