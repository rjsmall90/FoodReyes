package com.foodreyes.menu.Controller;

import com.foodreyes.menu.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/item")
public class ItemController {

    @Autowired
    ItemService itemService;





}
