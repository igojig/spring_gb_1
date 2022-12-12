package ru.igojig.lesson3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.lesson3.model.Product;
import ru.igojig.lesson3.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getById(Long id){
        return productRepository.getById(id);
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }
}
