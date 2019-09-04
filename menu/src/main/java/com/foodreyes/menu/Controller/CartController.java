package com.foodreyes.menu.Controller;


import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    Item item;

    @Autowired
    CartService cartService;



}
