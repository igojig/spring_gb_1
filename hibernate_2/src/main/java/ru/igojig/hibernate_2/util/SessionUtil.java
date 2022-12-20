package ru.igojig.hibernate_2.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.igojig.hibernate_2.entity.Customer;
import ru.igojig.hibernate_2.entity.Order;
import ru.igojig.hibernate_2.entity.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SessionUtil {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @PreDestroy
    public void close() {
        if (sessionFactory != null) {
            System.out.println("Close SessionFactory");
            sessionFactory.close();
        }
    }

}
