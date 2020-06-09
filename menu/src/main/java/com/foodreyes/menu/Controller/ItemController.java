package com.foodreyes.menu.Controller;

import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(value ="/item/add")
    public Item addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping(value = "/item/find_all")
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping(value = "/item/findByName{name}")
    public Item findByName(@RequestBody String item) {
        return itemService.find(item);
    }

    @DeleteMapping(value = "/item/delete")
    public void deleteItem(@RequestBody Item item) {
        itemService.delete(item);
    }




}
