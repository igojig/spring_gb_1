package ru.igojig.hibernate_2;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.igojig.hibernate_2.config.Config;
import ru.igojig.hibernate_2.entity.Customer;
import ru.igojig.hibernate_2.entity.Order;
import ru.igojig.hibernate_2.entity.Product;
import ru.igojig.hibernate_2.services.CustomerService;
import ru.igojig.hibernate_2.services.OrderService;
import ru.igojig.hibernate_2.services.ProductService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {

            CustomerService customerService = context.getBean(CustomerService.class);
            ProductService productService = context.getBean(ProductService.class);
            OrderService orderService=context.getBean(OrderService.class);

            System.out.println("===================");
            System.out.println("Find all customers");
            List<Customer> customers = customerService.findAll();
            System.out.println(customers);
            System.out.println("===================");

            System.out.println("===================");
            System.out.println("Find all products");
            List<Product> products = productService.findAll();
            System.out.println(products);
            System.out.println("===================");

            System.out.println("===================");
            System.out.println("Find products for Customer#3");
            List<Product> products1 = productService.findProductsByCustomerId(3L);
            System.out.println(products1);
            System.out.println("============================");

            System.out.println("============================");
            System.out.println("Find all customers for Product#5");
            List<Customer> customers1 = customerService.findCustomersByProductId(5L);
            System.out.println(customers1);
            System.out.println("============================");

            System.out.println("============================");
            System.out.println("Find price for Customer#2 and Product#3");// 240, 330
            List<Order> orders= orderService.getPriceByCustomerAndProduct(2L, 3L);
            System.out.println(orders);
            System.out.println("============================");
        }
        // autoclose context->close SessionFactory
    }
}
