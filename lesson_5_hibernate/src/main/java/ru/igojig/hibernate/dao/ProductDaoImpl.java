package ru.igojig.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.annotations.Comment;
import ru.igojig.hibernate.SessionUtil;
import ru.igojig.hibernate.model.Product;

import java.util.List;


public class ProductDaoImpl implements ProductDao {
    @Override
    public Product findById(Long id) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("Select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select p from Product p where p.title=:title", Product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            Product product= session.get(Product.class, id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Product product) {
        try (Session session = SessionUtil.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }
}
