package ru.igojig.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.igojig.component.Cart;
import ru.igojig.service.CartService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CartRepository {
    private List<Cart> carts;

    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @PostConstruct
    public void init(){
        carts=new ArrayList<>();
    }

   public void addCard(Cart cart){
        carts.add(cart);
    }

    public void removeById(Long id){
        carts.removeIf(c->c.getId().equals(id));
    }

   public List<Cart> getAll(){
        return Collections.unmodifiableList(carts);
    }


    public Optional<Cart> getById(Long id) {
        return carts.stream().filter(c->c.getId().equals(id)).findAny();
    }
}
