package ru.mail.park.DAO2;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.nio.file.Paths;


public class HabernateUtil {

//    private static SessionFactory sessionFactory = null;
    private static final SessionFactory sessionFactory = buildSessionFactory();


    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure(
                    new File("/Users/serqeycheremisin/CheremisinSergey/Tech-mail/Semester2/Java/osmos3/src/hibernate.cfg.xml")).buildSessionFactory();


        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


//    public static SessionFactory getSessionFactory(){
//        if(sessionFactory == null){
//            try{
//                SessionFactory sessionFactory = null;
//
//                Configuration configuration = new Configuration();
//                configuration.configure(Paths.get("/Users/serqeycheremisin/CheremisinSergey/Tech-mail/Semester2/Java/osmos3/src/hibernate.cfg.xml").toFile());
//
//                sessionFactory = configuration.buildSessionFactory();
//                return sessionFactory;
//            }catch (HibernateException e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
//    }

}
