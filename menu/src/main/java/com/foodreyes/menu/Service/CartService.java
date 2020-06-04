package com.foodreyes.menu.Service;

import com.foodreyes.menu.Model.Cart;
import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        public Cart findAllItems(Cart cart){
        return cartRepo.findAll(cart.getItems());
    }


//    public Cart find(Long cartId) {
//        return cartRepo.findById(cartId).get();
//    }

//    public void delete(Cart cart) {
//        cartRepo.delete(cart);
//    }
}
