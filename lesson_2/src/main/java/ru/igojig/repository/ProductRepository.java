package ru.igojig.repository;

import ru.igojig.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository {
    Optional<Product> findProductById(Long id);
    List<Product> findAllProducts();
}
