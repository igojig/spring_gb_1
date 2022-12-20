package ru.igojig.hibernate_2.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.igojig.hibernate_2.dao.ProductDao;
import ru.igojig.hibernate_2.entity.Product;
import ru.igojig.hibernate_2.util.SessionUtil;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionUtil sessionUtil;

    @Override
    public List<Product> findProductsByCustomerId(Long id) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();


            List<Product> products = session
                    .createQuery("select p from Product p " +
                                    "inner join p.orders o " +
                                    "inner join o.customer c " +
                                    "where c.id=:id",
                            Product.class)
                    .setParameter("id", id)
                    .getResultList();

//            Native query - works fine

//            List<Product> products2 = session
//                    .createNativeQuery("select * from products  " +
//                                    "join orders on orders.product_id=products.id " +
//                                    "join customers on customers.id=orders.customer_id " +
//                                    "where customers.id=:id",
//                            Product.class)
//                    .setParameter("id", id)
//                    .getResultList();

            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            List<Product> products=session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }
}
