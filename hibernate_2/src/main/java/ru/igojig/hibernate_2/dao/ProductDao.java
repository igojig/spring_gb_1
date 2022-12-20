package ru.igojig.hibernate_2.dao;

import ru.igojig.hibernate_2.entity.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findProductsByCustomerId(Long id);

    public List<Product> findAll();

}
