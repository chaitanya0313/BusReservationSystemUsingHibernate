package com.bus.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    // SessionFactory is heavy to create (reads cfg.xml, builds mappings),
    // so we build it only ONCE per application and reuse it everywhere.
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            // Configuration() automatically looks for hibernate.cfg.xml
            // on the classpath (src/main/resources is on the classpath).
            Configuration configuration = new Configuration();
            configuration.configure(); // loads hibernate.cfg.xml

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}