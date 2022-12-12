package ru.igojig.lesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.igojig.lesson3.model.Product;
import ru.igojig.lesson3.service.ProductService;

import java.util.List;

@RestController
public class ProductRestController {

    // через Postman

    // GET localhost:8189/market/api/v1/products - вернуть список всех продуктов
    // GET localhost:8189/market/api/v1/products/{id} - вернуть продукт с указанным id
    // POST localhost:8189/market/api/v1/products - создать новый продукт (* пусть ид у продукта подставляется автоматом на бэке, макс текущий ид + 1)
    // DELETE localhost:8189/market/api/v1/products - удаляет все продукты
    // DELETE localhost:8189/market/api/v1/products/{id} - удаляет продукт с указанным id

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/api/v1/products/{id}")
    public Product getById(@PathVariable("id") Long id){
        return productService.getById(id).orElseThrow(()->new RuntimeException("Unknown product"));
    }

    @PostMapping("/api/v1/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/api/v1/products/{id}")
    public void deleteById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

    @DeleteMapping("/api/v1/products")
    public void deleteAll(){
        productService.deleteAll();
    }



}
