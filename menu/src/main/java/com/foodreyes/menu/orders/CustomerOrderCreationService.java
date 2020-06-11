package com.foodreyes.menu.orders;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CustomerOrderCreationService implements CustomerOrderCreator {

    private final CustomerOrderRepository customerOrderRepository;

    @Override
    public CustomerOrder createInitialOrder(UUID customerId) {
        return customerOrderRepository.save(CustomerOrder.builder().customerId(customerId).build());
    }
}
