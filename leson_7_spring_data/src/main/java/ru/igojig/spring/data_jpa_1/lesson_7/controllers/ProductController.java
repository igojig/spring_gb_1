package ru.igojig.spring.data_jpa_1.lesson_7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.igojig.spring.data_jpa_1.lesson_7.entities.Product;
import ru.igojig.spring.data_jpa_1.lesson_7.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    // http://localhost:8189/app
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id).get();
    }

    @GetMapping("/products/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "Product: " + id + " delete";
    }

    @PostMapping("/products")
    public String add(@RequestBody Product product) {
//        product.setId(null);
        productService.add(product);
        return "Product: " + product + " added";
    }

    @GetMapping("/productsMoreThan")
    public List<Product> findByPriceGreaterThan(@RequestParam(value = "price") Integer price) {
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/productsLessThan")
    public List<Product> findByPriceLessThan(@RequestParam(value = "price") Integer price) {
        return productService.findByPriceLessThan(price);
    }

    @GetMapping("/productsBetween")
    public List<Product> findByPriceBetween(@RequestParam(value = "minPrice", defaultValue = "0") Integer minPrice,
                                            @RequestParam(value = "maxPrice", defaultValue = "100") Integer maxPrice) {
        return productService.findByPriceBetween(minPrice, maxPrice);
    }


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}
