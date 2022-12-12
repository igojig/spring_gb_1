package ru.igojig.lesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.igojig.lesson3.model.Product;
import ru.igojig.lesson3.service.ProductService;

import java.util.List;

@Controller
public class ProductFormController {
    // localhost:8189/market/products - список всех продуктов
    // localhost:8189/market/add - добавление продукта


    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAll(Model model){
        List<Product> products=productService.getAll();
        model.addAttribute("productList", products);
        return "showProducts";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/products")
    public String createProduct(@ModelAttribute("product") Product product){
//        System.out.println(product);
        productService.addProduct(product);
        return "redirect:/products";
    }
}
