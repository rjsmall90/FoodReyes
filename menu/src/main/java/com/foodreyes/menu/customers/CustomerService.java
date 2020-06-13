package com.foodreyes.menu.customers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CustomerService {

    private final CustomerRepository customerRepository;

    Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
