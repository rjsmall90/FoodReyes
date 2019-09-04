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
    ItemService itemService;git branch

    @PostMapping(value ="/add")
    public Item addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping(value = "/find_all")
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping(value = "findByName{name}")
    public Item findAll(@RequestBody Item item) {
        return itemService.find(item.getName());
    }

    @DeleteMapping(value = "/delete")
    public void deleteItem(@RequestBody Item item) {
        itemService.delete(item);
    }




}
