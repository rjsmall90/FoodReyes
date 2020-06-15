package com.foodreyes.menu.notifications;

import com.foodreyes.menu.core.email.EmailService;
import com.foodreyes.menu.core.email.EmailTemplate;
import com.foodreyes.menu.orders.CustomerOrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerOrderNotificationServiceTest {

    CustomerOrderDTO customerOrderDTO;
    EmailTemplate emailTemplate;

    @Mock
    private EmailService emailService;

    @Mock
    private CustomerOrderNotificationBuilder customerOrderNotificationBuilder;

    private CustomerOrderNotificationService customerOrderNotificationService;

    @BeforeEach
    void setUp() {
        customerOrderDTO = new CustomerOrderDTO();
        emailTemplate = new EmailTemplate();

        customerOrderNotificationService = new CustomerOrderNotificationService(emailService, customerOrderNotificationBuilder);
    }

    @Test
    void sendCustomerOrderNotification() throws Exception {
        when(customerOrderNotificationBuilder.createCustomerOrderNotification(customerOrderDTO)).thenReturn(emailTemplate);

        customerOrderNotificationService.sendCustomerOrderNotification(customerOrderDTO);

        verify(emailService, times(1)).sendEmailWithoutAttachments(emailTemplate);
    }
}