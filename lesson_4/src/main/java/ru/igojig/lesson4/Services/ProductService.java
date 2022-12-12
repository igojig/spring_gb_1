package ru.igojig.lesson4.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.lesson4.model.Product;
import ru.igojig.lesson4.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long id, int delta) {
        Product product=productRepository.getById(id);
        product.setPrice(product.getPrice()+delta);
        // productRepository.save();
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
}
