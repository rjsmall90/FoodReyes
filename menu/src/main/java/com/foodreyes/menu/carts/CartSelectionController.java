package com.foodreyes.menu.carts;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
