package ru.igojig.hibernate.dao;

import ru.igojig.hibernate.model.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();

    Product findByTitle(String title);

    void deleteById(Long id);

    void saveOrUpdate(Product product);

}
