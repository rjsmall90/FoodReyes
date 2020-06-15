package com.foodreyes.menu.orders;

import com.foodreyes.menu.carts.CartSelectionDTO;
import com.foodreyes.menu.carts.CartSelectionRepository;
import com.foodreyes.menu.customers.Customer;
import com.foodreyes.menu.customers.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerOrderMapperTest {

    CustomerOrder customerOrder;
    Customer customer;
    List<CartSelectionDTO> cartSelectionDTOS;
    CustomerOrderDTO dto;

    private static final Long ORDER_NUMBER = 1L;
    private static final UUID CUSTOMER_ID = UUID.fromString("5352522f-48a2-4bb9-8108-3b432a99bd6b");
    private static final BigDecimal ORDER_TOTAL = BigDecimal.ONE;
    private static final String USERNAME = "test.username";
    private static final String FIRST_NAME = "TestFirst";
    private static final String LAST_NAME = "TestLast";
    private static final String EMAIL_ADDRESS = "test-email@test.com";

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CartSelectionRepository cartSelectionRepository;

    private CustomerOrderMapper customerOrderMapper;

    @BeforeEach
    void setUp() {
        customerOrderMapper = new CustomerOrderMapper(customerRepository, cartSelectionRepository);
    }

    private void setUpTestData() {
        setCustomerOrder();
        setCustomer();
        setDTO();
    }

    private void setCustomerOrder() {
        customerOrder = CustomerOrder.builder()
                .orderNumber(ORDER_NUMBER)
                .customerId(CUSTOMER_ID)
                .orderTotal(ORDER_TOTAL)
                .build();
    }

    private void setCustomer() {
        customer = Customer.builder()
                .username(USERNAME)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .emailAddress(EMAIL_ADDRESS)
                .build();
    }

    private void setDTO() {
        cartSelectionDTOS = new ArrayList<>();

        dto = CustomerOrderDTO.builder()
                .orderNumber(ORDER_NUMBER)
                .customerId(CUSTOMER_ID)
                .username(USERNAME)
                .customerName(FIRST_NAME + " " + LAST_NAME)
                .customerEmailAddress(EMAIL_ADDRESS)
                .orderTotal(ORDER_TOTAL)
                .cartSelectionDTOS(cartSelectionDTOS)
                .build();
    }

    @Test
    void buildCustomerOrderDTO() {
        setUpTestData();
        when(cartSelectionRepository.findCartSelectionDTOsByCustomerId(CUSTOMER_ID)).thenReturn(cartSelectionDTOS);
        when(customerRepository.findCustomerByCustomerId(CUSTOMER_ID)).thenReturn(customer);

        CustomerOrderDTO mappedDTO = customerOrderMapper.buildCustomerOrderDTO(customerOrder);

        Assertions.assertEquals(dto.getOrderNumber(), mappedDTO.getOrderNumber(), "Order numbers do not match");
        Assertions.assertEquals(dto.getCustomerId(), mappedDTO.getCustomerId(), "Customer ids do not match");
        Assertions.assertEquals(dto.getUsername(), mappedDTO.getUsername(), "Usernames do not match");
        Assertions.assertEquals(dto.getCustomerName(), mappedDTO.getCustomerName(), "Order numbers do not match");
        Assertions.assertEquals(dto.getCustomerEmailAddress(), mappedDTO.getCustomerEmailAddress(), "Email addresses do not match");
        Assertions.assertEquals(dto.getOrderTotal(), mappedDTO.getOrderTotal(), "Order totals do not match");
        Assertions.assertEquals(dto.getCartSelectionDTOS(), mappedDTO.getCartSelectionDTOS(), "Cart selections do not match");
    }
}