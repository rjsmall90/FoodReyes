package com.foodreyes.menu.carts;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartSelectionController {

    private final CartSelectionService cartSelectionService;

    @PostMapping("/carts")
    public ResponseEntity<CartSelection> addItemToCart(@RequestBody CartSelection cartSelection) {
        return new ResponseEntity<>(cartSelectionService.addItemToCart(cartSelection), HttpStatus.CREATED);
    }

    @GetMapping("/carts/{customerId}")
    public ResponseEntity<List<CartSelectionDTO>> findAllCartSelectionsForCustomer(@PathVariable("customerId")UUID customerId) {
        return ResponseEntity.ok(cartSelectionService.findAllCartSelectionsForCustomer(customerId));
    }

    @DeleteMapping("/carts/{cartId}/{customerId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable("cartId") Long cartId,
                                                @PathVariable("customerId") UUID customerId) {
        cartSelectionService.removeItemFromCart(cartId, customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
