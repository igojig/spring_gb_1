package ru.igojig.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.igojig.model.Product;
import ru.igojig.service.CartService;
import ru.igojig.service.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    static int count=0;

    private Long id;

    private List<Product> products;
    private CartService cartService;
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCardService(CartService cartService) {
        this.cartService = cartService;
    }

    @PostConstruct
    void init(){
        products=new ArrayList<>();
        id = (long) ++count;
    }

    public void addProductById(Long id){
        Product product=productService.getProductById(id).get();
        products.add(product);
    }

    public void removeProductById(Long id){
        products.removeIf(p->p.getId().equals(id));
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }

    public void removeAllProducts(){
        products.clear();
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cardCount=" + id +
                ", products=" + products +
                '}';
    }
}
