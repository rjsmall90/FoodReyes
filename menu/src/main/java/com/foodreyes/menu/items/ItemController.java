package com.foodreyes.menu.items;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value ="/items")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> findAllItems(){
        return ResponseEntity.ok(itemService.findAllItems());
    }

    @GetMapping(value = "/items/{itemId}")
    public ResponseEntity<Item> findItemByItemId(@PathVariable("itemId") Long itemId) {
        return ResponseEntity.ok(itemService.findItemById(itemId));
    }

    @PutMapping(value = "/items")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.updateItem(item));
    }

    @DeleteMapping(value = "/items/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
