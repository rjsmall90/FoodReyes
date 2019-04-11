package com.foodreyes.menu.Service;

import com.foodreyes.menu.Model.Cart;
import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepo cartRepo;

    public Cart save(Cart cart){
        return cartRepo.saveAndFlush(cart);
    }
    public Cart update(Cart cart) {
        return cartRepo.save(cart);
    }
    public Cart find(Long cartId) {
        return cartRepo.findById(cartId).get();
    }
//    public Cart findAllItems(Cart itemId){
//        return cartRepo.findAllById(itemId.getItems()).get();
//    }
    public void delete(Cart cart) {
        cartRepo.delete(cart);
    }
}
