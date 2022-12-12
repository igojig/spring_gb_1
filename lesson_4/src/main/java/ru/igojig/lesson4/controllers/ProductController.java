package ru.igojig.lesson4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.igojig.lesson4.Services.ProductService;
import ru.igojig.lesson4.model.Product;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

    @PutMapping("/products")
    public void changePrice( @RequestParam("delta") int delta, @RequestParam(name = "productId") Long id){
        productService.changePrice(id, delta);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
            productService.addProduct(product);
    }

}
