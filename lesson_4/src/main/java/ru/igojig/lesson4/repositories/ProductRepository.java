package ru.igojig.lesson4.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import ru.igojig.lesson4.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> products;

    @PostConstruct
    public void init(){
        products=new ArrayList<>();
        products.add(new Product(1L,"Car", 10_000));
        products.add(new Product(2L,"Robot", 20_000));
        products.add(new Product(3L,"Toy", 5_000));
    }
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(p->p.getId().equals(id));
    }

    public Product getById(Long id) {
        return products.stream().filter(p->p.getId().equals(id)).findAny().get();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
