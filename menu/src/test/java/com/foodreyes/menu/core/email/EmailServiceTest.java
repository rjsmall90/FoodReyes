package com.foodreyes.menu.core.email;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.MessagingException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    private EmailTemplate emailTemplate;

    @Mock
    private JavaMailSender javaMailSender;

    private EmailService emailService;

    @BeforeEach
    void setUp() {
        emailTemplate = new EmailTemplate();

        emailService = new EmailService(javaMailSender);
    }

    @Test
    void sendEmailWithoutAttachments() throws MessagingException {
        doNothing().when(javaMailSender).send(any(MimeMessagePreparator.class));

        emailService.sendEmailWithoutAttachments(emailTemplate);

        verify(javaMailSender, times(1)).send(any(MimeMessagePreparator.class));
    }
}