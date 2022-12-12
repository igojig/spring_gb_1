package ru.igojig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.igojig.component.Cart;
import ru.igojig.config.Config;
import ru.igojig.model.Product;
import ru.igojig.service.CartService;
import ru.igojig.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    Scanner sc = new Scanner(System.in);
    AnnotationConfigApplicationContext context;
    ProductService productService;
    CartService cartService;
    Long currentCartId;

    MainApp() {
        context = new AnnotationConfigApplicationContext(Config.class);
        productService = context.getBean(ProductService.class);
        cartService = context.getBean(CartService.class);
        currentCartId = 0L;
    }

    public static void main(String[] args) {

        MainApp mainApp = new MainApp();
        loop:
        while (true) {
            mainApp.mainMenu();
            int ans = mainApp.getUserInput("Enter option: ");
            switch (ans) {
                case 1 -> mainApp.printAllProducts();
                case 2 -> mainApp.processCartMenu();
                case 3 -> {
                    mainApp.close();
                    break loop;
                }
            }
        }
    }

    public void printAllProducts() {
        System.out.println("All products:");
        productService.getAllProducts().forEach(s -> System.out.printf("\tId: %s, Title: %s, Price: %s%n", s.getId(), s.getTitle(), s.getPrice()));
    }

    public void cardMenu() {
        if (currentCartId.equals(0L)) {
            System.out.println("No cart");
        } else {
            System.out.println("Active cart: " + currentCartId);
//            showCartDetails();
        }
        System.out.println("Cart menu:");
        System.out.println("\t1: Create cart");
        System.out.println("\t2: Select active cart");
        System.out.println("\t3: Add product to active cart");
        System.out.println("\t4: List carts");
        System.out.println("\t5: Main menu");
    }

    private void showCartDetails() {
        Cart cart = cartService.getById(currentCartId).get();
        List<Product> products = cart.getAllProducts();
        if(products.isEmpty()){
            System.out.println("cart is empty");
        } else {
            products.forEach(p -> System.out.println("\t" + p));
        }
    }

    public void mainMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1: View products");
        System.out.println("\t2: Cart menu");
        System.out.println("\t3: Exit");

    }

    public int getUserInput(String msg) {
        System.out.println(msg);
        int answer;
        while (true) {
            try {
                answer = sc.nextInt();
                return answer;
            } catch (RuntimeException e) {
                // выкидываем что было введено
                sc.next();
                System.out.println("Incorrect input");
            }
        }
    }

    public void processCartMenu() {

        while (true) {
            cardMenu();
            int ans = getUserInput("Enter option:");
            switch (ans) {
                case 1 -> {
                    // новая корзина (Scope prototype)
                    Cart cart = context.getBean(Cart.class);
                    currentCartId = cart.getId();
                    cartService.addCart(cart);
                    System.out.println("New cart added. Id=" + currentCartId);
                }
                case 2 -> {
                    // select active cart

                    if (currentCartId.equals(0L)) {
                        System.out.println("No cart available");
                        continue;
                    }
                    System.out.println("You have cart(s): " + cartService.getAll().size());
                    ans = getUserInput("Enter cart number: ");
                    if (ans == 0 || ans > cartService.getAll().size()) {
                        System.out.println("Incorrect cart number");
                    } else {
                        currentCartId = (long) ans;
                    }
                }
                case 3 -> {
                    // add product to active cart
                    if (currentCartId.equals(0L)) {
                        System.out.println("No cart available");
                        continue;
                    }
                    printAllProducts();
                    int p = getUserInput("Enter product number: ");
                    if (p < 1 || p > productService.getAllProducts().size()) {
                        System.out.println("Incorrect product number");
                        continue;
                    }
                    cartService.getById(currentCartId).get().addProductById((long) p);
                    System.out.printf("Product #%s was added to cart %s%n%n", p, currentCartId.toString());
                }
                case 4 -> {
                    // list all carts
                    if (!cartService.getAll().isEmpty()) {
                        System.out.println("List of carts:");
                        List<Cart> carts = cartService.getAll();
                        for (Cart c : carts) {
                            System.out.println("Cart: " + c.getId());
                            List<Product> products = c.getAllProducts();
                            if (products.isEmpty()) {
                                System.out.println("\tCart is empty");
                            } else {
                                for (Product pr : products) {
                                    System.out.println("\t" + pr);
                                }
                            }
                        }
                        System.out.println();

//                        cartService.getAll().forEach(s -> System.out.println("\t" + s));
                    } else {
                        System.out.println("No carts available");
                    }
                }
                case 5 -> {
                    // exit
                    return;
                }
            }

        }
    }

    public void close() {
        sc.close();
        context.close();
//        System.exit(0);
    }
}