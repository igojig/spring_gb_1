package ru.igojig.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.igojig.hibernate.model.Product;

import javax.persistence.EntityManager;

public class SessionUtil {
    private static SessionFactory sessionFactory;

    public static void init(){
        sessionFactory= new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public static void close(){
        if(sessionFactory!=null){
            sessionFactory.close();
        }
    }

}
