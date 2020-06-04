package com.foodreyes.menu.Controller;


import com.foodreyes.menu.Model.Cart;
import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    Item item;

    public List<Item> orders;

    @PostMapping(value = "/cart/add_to_cart")
    public void addToCart(@RequestBody Cart cart) {
        orders.add(item);
        cart.setItems(orders);
    }

    @PostMapping(value = "/cart/submit_order")
    public Cart addOrder(@RequestBody Cart cart) {
        return cartService.save(cart);
    }



}
