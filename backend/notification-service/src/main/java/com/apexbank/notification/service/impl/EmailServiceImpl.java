package com.apexbank.notification.service.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.notification.exception.EmailSendingException;
import com.apexbank.notification.service.EmailService;
import com.apexbank.notification.template.EmailTemplateService;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailTemplateService templateService;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void send(NotificationEvent event) {

        try {

            Context context = new Context();

            if (event.getVariables() != null) {
                context.setVariables(event.getVariables());
            }

            String html =
                    templateService.process(event);

            MimeMessage mimeMessage =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(
                            mimeMessage,
                            true,
                            "UTF-8");

            helper.setFrom(from);
            helper.setTo(event.getRecipient());
            helper.setSubject(event.getSubject());
            helper.setText(html, true);

            mailSender.send(mimeMessage);

        } catch (Exception ex) {

            throw new EmailSendingException(
                    "Unable to send email",
                    ex);

        }
    }
}