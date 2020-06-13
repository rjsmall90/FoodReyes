package com.foodreyes.menu.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @PutMapping("/orders/{orderNumber}")
    public ResponseEntity<CustomerOrder> submitPaidOrder(@PathVariable("orderNumber") Long orderNumber) {
        return ResponseEntity.ok(customerOrderService.submitPaidOrder(orderNumber));
    }
}
