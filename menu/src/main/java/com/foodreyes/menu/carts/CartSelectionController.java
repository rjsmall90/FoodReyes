package com.foodreyes.menu.carts;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartSelectionController {

    private final CartSelectionService cartSelectionService;

    @PostMapping("/cart")
    public ResponseEntity<CartSelection> addItemToCart(@RequestBody CartSelection cartSelection) {
        return new ResponseEntity<>(cartSelectionService.addItemToCart(cartSelection), HttpStatus.CREATED);
    }
}
