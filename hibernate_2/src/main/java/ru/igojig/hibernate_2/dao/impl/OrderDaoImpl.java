package ru.igojig.hibernate_2.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.igojig.hibernate_2.dao.OrderDao;
import ru.igojig.hibernate_2.util.SessionUtil;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    SessionUtil sessionUtil;

    @Override
    public Integer getPriceByCustomerAndProduct(Long customerId, Long productId) {
        try (Session session = sessionUtil.getSession()) {
            session.beginTransaction();
            Integer price = session.createQuery("select o.price from Order o " +
                            "where o.customer.id=:customerId and o.product.id=:productId", Integer.class)
                    .setParameter("customerId", customerId)
                    .setParameter("productId", productId)
                    .getSingleResult();
            session.getTransaction().commit();
            return price;
        }
    }
}
