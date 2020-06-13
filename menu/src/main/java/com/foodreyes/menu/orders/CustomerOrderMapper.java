package com.foodreyes.menu.orders;

import com.foodreyes.menu.carts.CartSelectionDTO;
import com.foodreyes.menu.carts.CartSelectionRepository;
import com.foodreyes.menu.customers.Customer;
import com.foodreyes.menu.customers.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CustomerOrderMapper {

    private final CustomerRepository customerRepository;
    private final CartSelectionRepository cartSelectionRepository;

    public CustomerOrderDTO buildCustomerOrderDTO(CustomerOrder customerOrder) {
        List<CartSelectionDTO> cartSelectionDTOS = cartSelectionRepository.findCartSelectionDTOsByCustomerId(customerOrder.getCustomerId());
        Customer customer = customerRepository.findCustomerByCustomerId(customerOrder.getCustomerId());

        return CustomerOrderDTO.builder()
                .orderNumber(customerOrder.getOrderNumber())
                .customerId(customerOrder.getCustomerId())
                .username(customer.getUsername())
                .customerName(customer.getFirstName() + " " + customer.getLastName())
                .customerEmailAddress(customer.getEmailAddress())
                .orderTotal(customerOrder.getOrderTotal())
                .cartSelectionDTOS(cartSelectionDTOS)
                .build();
    }
}
