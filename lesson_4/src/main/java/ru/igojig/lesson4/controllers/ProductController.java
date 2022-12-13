package ru.igojig.lesson4.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.igojig.lesson4.Services.ProductService;
import ru.igojig.lesson4.model.Product;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
    @GetMapping
    public List<Product> getAllProducts(){
        logger.info("get");
        return productService.getAllProducts();
    }

//    @DeleteMapping("/products/{id}")
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
    }

//    @PutMapping("/products")
    @PutMapping
    public void changePrice( @RequestParam("delta") Integer delta, @RequestParam(name = "productId") Long id){
        productService.changePrice(id, delta);
    }

//    @PostMapping("/products")
    @PostMapping
    public void addProduct(@RequestBody Product product){
            productService.addProduct(product);
    }

}
