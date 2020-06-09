package com.foodreyes.menu.Controller;


import com.foodreyes.menu.Model.Cart;
import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Service.CartService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {


    @Autowired
    CartService cartService;

    Cart cart;

    List<Item> orders = new ArrayList<>();

    @PostMapping(value = "/cart/addItems")
    public void addToCart(@RequestBody Item item) {
        orders.add(item);
    }

    @GetMapping(value="/cart/openCart")
    public List<Item> viewCart() {
        return orders;
    }

    @PostMapping(value = "/cart/submit_order")
    public Cart addOrder() {
        cart.setItems(orders);
        return cartService.save(cart);
    }




}
