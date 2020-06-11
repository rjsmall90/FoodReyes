package com.foodreyes.menu.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    CustomerOrder createOrder(CustomerOrder customerOrder) {
        CustomerOrder newCustomerOrder = customerOrderRepository.save(customerOrder);
        return newCustomerOrder;
    }
}
