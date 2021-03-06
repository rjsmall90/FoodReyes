package com.foodreyes.menu.Service;

import com.foodreyes.menu.Model.Item;
import com.foodreyes.menu.Repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepo itemRepo;

    public Item save(Item item){
        return itemRepo.saveAndFlush(item);
    }
    public Item update(Item item) {
        return itemRepo.save(item);
    }

    public List<Item> findAll() {
        return new ArrayList<>(itemRepo.findAll());
    }
    public Item find(String name) {
        return itemRepo.findByName(name);
    }
    public void delete(Item item) {
        itemRepo.delete(item);
    }

}
