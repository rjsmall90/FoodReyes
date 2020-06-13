package com.foodreyes.menu.core.email;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailService {

    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmailWithoutAttachments(EmailTemplate emailTemplate) throws MessagingException {
        try {
            mailSender.send(buildEmailWithoutAttachments(emailTemplate));
        } catch (MailException e) {
            throw new MessagingException("Could not send email" + emailTemplate.toString() + '\n' + e.getMessage());
        }
    }

    private MimeMessagePreparator buildEmailWithoutAttachments(EmailTemplate emailTemplate) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(emailTemplate.getFrom());
            messageHelper.setSubject(emailTemplate.getSubject());
            messageHelper.setText(emailTemplate.getText(), true);

            if (emailTemplate.getTo() != null) {
                messageHelper.setTo(emailTemplate.getTo());
            }

            if (emailTemplate.getBccAddresses() != null) {
                messageHelper.setBcc(emailTemplate.getBccAddresses());
            }
        };
    }
}
