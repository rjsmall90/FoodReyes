package com.foodreyes.menu.customers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class CustomerService {

    private final CustomerRepository customerRepository;

    Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
//    String findCustomerIdByUsername(String username) {
//        return customerRepository.findCustomerIdByUsername(username).toString().replaceAll("\\-", "");
//    }

    String findCustomerIdByUsername(String username) {
        return customerRepository.findCustomerIdByUsername(username).toString();
    }

    List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}