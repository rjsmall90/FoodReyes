package com.foodreyes.menu.notifications;

import com.foodreyes.menu.core.email.EmailService;
import com.foodreyes.menu.orders.CustomerOrderDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CustomerOrderNotificationService implements CustomerOrderNotifier {

    private final EmailService emailService;
    private final CustomerOrderNotificationBuilder customerOrderNotificationBuilder;

    @Override
    public void sendCustomerOrderNotification(CustomerOrderDTO dto) {
        try {
            emailService.sendEmailWithoutAttachments(customerOrderNotificationBuilder.createCustomerOrderNotification(dto));
        } catch (MessagingException e) {
            System.out.println("Could not send notification: " + e.getMessage());
        }
    }
}
