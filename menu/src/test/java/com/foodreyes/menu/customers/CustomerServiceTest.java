package com.foodreyes.menu.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private Customer customer;
    private List<Customer> customers;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customer = new Customer();

        customers = new ArrayList<>();
        customers.add(customer);

        customerService = new CustomerService(customerRepository);
    }

    @Test
    void createCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer newCustomer = customerService.createCustomer(customer);

        Assertions.assertEquals(customer, newCustomer, "Customers do not match");
    }

    @Test
    void findAllCustomers() {
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> returnedCustomers = customerService.findAllCustomers();

        Assertions.assertEquals(customers, returnedCustomers, "Lists of customers do not match");
    }
}