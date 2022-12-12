package ru.igojig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igojig.component.Cart;
import ru.igojig.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public void addCart(Cart cart){
        cartRepository.addCard(cart);
    }

    public Optional<Cart> getById(Long id){
        return cartRepository.getById(id);
    }
    public void removeById(Long id){
        cartRepository.removeById(id);
    }

    public List<Cart> getAll(){
        return cartRepository.getAll();
    }
}
