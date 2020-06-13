package com.foodreyes.menu.notifications;

import com.foodreyes.menu.carts.CartSelectionDTO;
import com.foodreyes.menu.core.email.EmailTemplate;
import com.foodreyes.menu.orders.CustomerOrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class CustomerOrderNotificationBuilder {

    @Value("${spring.mail.customer.service.noreply.email.address}")
    private String noReplyEmailAddress;

    EmailTemplate createCustomerOrderNotification(CustomerOrderDTO dto) {
        EmailTemplate emailTemplate = new EmailTemplate();

        String itemInfo = itemInfo(dto);

        emailTemplate.setFrom(noReplyEmailAddress);
        emailTemplate.setTo(dto.getCustomerEmailAddress());
        emailTemplate.setSubject("We received your order!");
        emailTemplate.setText("Hey " + dto.getCustomerName() + "! We got your order and you will receive shipping information shortly." +
                "\nSee below for order details." +
                "\n" +
                "\nOrder Number: " + dto.getOrderNumber() +
                "\n" + itemInfo);

        return emailTemplate;
    }

    private String itemInfo(CustomerOrderDTO dto) {
        List<String> items = new ArrayList<>();
        for(CartSelectionDTO cartSelectionDTO : dto.getCartSelectionDTOS()) {
            items.add(cartSelectionDTO.getName() + "\n" + cartSelectionDTO.getPrice() + "\n");
        }

        return items.toString();
    }
}
