package com.foodreyes.menu.orders;

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
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @PostMapping("/orders")
    public ResponseEntity<CustomerOrder> createNewOrder(@RequestBody CustomerOrder customerOrder) {
        return new ResponseEntity<>(customerOrderService.createOrder(customerOrder), HttpStatus.CREATED);
    }
}
