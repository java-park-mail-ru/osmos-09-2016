package ru.mail.park.DAO2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by serqeycheremisin on 26/10/2016.
 */
public class HabernateUtil {
//    private static final SessionFactory sessionFactory;
    private static final SessionFactory sessionFactory = buildSessionFactory();
//    static {
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//static {
//    try {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//    } catch (Throwable ex) {
//        System.err.println("Initial SessionFactory creation failed.");
//        throw new ExceptionInInitializerError(ex);
//    }
//}
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure(
                    new File("hibernate.cgf.xml")).buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
