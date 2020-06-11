package com.foodreyes.menu.items;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value ="/item/add")
    public Item addItem(@RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> findAllItems(){
        return ResponseEntity.ok(itemService.findAllItems());
    }

    @GetMapping(value = "/{itemId}/items")
    public ResponseEntity<Item> findByName(@PathVariable("itemId") Long itemId) {
        return ResponseEntity.ok(itemService.findItemById(itemId));
    }

    @DeleteMapping(value = "/item/delete")
    public void deleteItem(@RequestBody Item item) {
        itemService.delete(item);
    }




}
