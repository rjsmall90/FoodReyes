package com.foodreyes.menu.notifications;

import com.foodreyes.menu.carts.CartSelectionDTO;
import com.foodreyes.menu.core.email.EmailTemplate;
import com.foodreyes.menu.orders.CustomerOrderDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerOrderNotificationBuilderTest {

    private CustomerOrderDTO customerOrderDTO;
    private CartSelectionDTO cartSelectionDTO;
    private List<CartSelectionDTO> cartSelectionDTOS;

    private static final String CUSTOMER_NAME = "Test customer name";
    private static final String CUSTOMER_EMAIL_ADDRESS = "test@test.com";
    private static final String SUBJECT = "We received your order!";
    private static final String ITEM_NAME = "Test item name";
    private static final Long ORDER_NUMBER = 1L;
    private static final BigDecimal ORDER_TOTAL = BigDecimal.ONE;

    @Value("${spring.mail.customer.service.noreply.email.address}")
    private String noReplyEmailAddress;

    private CustomerOrderNotificationBuilder customerOrderNotificationBuilder;

    @BeforeEach
    void setUp() {
        customerOrderDTO = new CustomerOrderDTO();

        customerOrderNotificationBuilder = new CustomerOrderNotificationBuilder();
    }

    private void setUpData() {
        setCustomerOrderDTO();
    }

    private void setCustomerOrderDTO() {
        setCartSelectionDTO();

        customerOrderDTO = CustomerOrderDTO.builder()
                .customerName(CUSTOMER_NAME)
                .orderNumber(ORDER_NUMBER)
                .cartSelectionDTOS(cartSelectionDTOS)
                .customerEmailAddress(CUSTOMER_EMAIL_ADDRESS)
                .build();
    }

    private void setCartSelectionDTO() {
        cartSelectionDTOS = new ArrayList<>();

        cartSelectionDTO = CartSelectionDTO.builder()
                .name(ITEM_NAME)
                .price(ORDER_TOTAL)
                .build();

        cartSelectionDTOS.add(cartSelectionDTO);
    }

    @Test
    void createCustomerOrderNotification() {
        setUpData();
        String text = "Hey " + customerOrderDTO.getCustomerName() + "! We got your order and you will receive shipping information shortly." +
                "\nSee below for order details." +
                "\n" +
                "\nOrder Number: " + customerOrderDTO.getOrderNumber() +
                "\n" + testItemInfo(customerOrderDTO);

        EmailTemplate emailTemplate = customerOrderNotificationBuilder.createCustomerOrderNotification(customerOrderDTO);

        Assertions.assertEquals(CUSTOMER_EMAIL_ADDRESS, emailTemplate.getTo());
        Assertions.assertEquals(noReplyEmailAddress, emailTemplate.getFrom());
        Assertions.assertEquals(SUBJECT, emailTemplate.getSubject());
        Assertions.assertEquals(text, emailTemplate.getText());
    }

    private String testItemInfo(CustomerOrderDTO dto) {
        List<String> items = new ArrayList<>();
        for(CartSelectionDTO cartSelectionDTO : dto.getCartSelectionDTOS()) {
            items.add(cartSelectionDTO.getName() + "\n" + cartSelectionDTO.getPrice() + "\n");
        }

        return items.toString();
    }
}