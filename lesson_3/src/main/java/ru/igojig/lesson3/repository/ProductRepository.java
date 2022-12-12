package ru.igojig.lesson3.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.igojig.lesson3.model.Product;

import java.util.*;

@Repository
public class ProductRepository {

    List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Milk", 100));
        products.add(new Product(2L, "Coffee", 200));
        products.add(new Product(3L, "Sugar", 300));
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> getById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findAny();
    }

    public void addProduct(Product product) {
        // автоматическое присвоение номера (id)
        Long id = products.stream()
                .map(Product::getId)
                .max(Comparator.comparingLong(o -> o)).orElse(0L);
        ++id;

        product.setId(id);
        products.add(product);
    }

    public void deleteById(Long id){
        products.removeIf(p->p.getId().equals(id));
    }

    public void deleteAll(){
        products.clear();
    }


}
