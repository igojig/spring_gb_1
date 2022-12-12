package ru.igojig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.model.Product;
import ru.igojig.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findProductById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAllProducts();
    }

}
