package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static final HibernateConfig INSTANCE;

    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateConfig();
     }

    private HibernateConfig() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();

    }

    public static HibernateConfig getInstance() {
        return  INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
