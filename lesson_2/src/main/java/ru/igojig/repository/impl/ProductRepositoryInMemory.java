package ru.igojig.repository.impl;

import org.springframework.stereotype.Repository;
import ru.igojig.model.Product;
import ru.igojig.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepositoryInMemory implements ProductRepository {

    List<Product> products;

    @PostConstruct
    void init(){
        products=new ArrayList<>();
        products.add(new Product(1L, "Bread", 10));
        products.add(new Product(2L, "Milk", 15));
        products.add(new Product(3L, "Cheese", 20));
        products.add(new Product(4L, "Sugar", 25));
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return products.stream().filter(p->p.getId().equals(id)).findAny();
    }

    @Override
    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(products);
    }
}
