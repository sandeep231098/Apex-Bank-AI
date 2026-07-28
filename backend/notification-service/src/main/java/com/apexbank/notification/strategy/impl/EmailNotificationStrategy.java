package com.apexbank.notification.strategy.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationType;
import com.apexbank.notification.service.EmailService;
import com.apexbank.notification.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotificationStrategy implements NotificationStrategy {

    private final EmailService emailService;

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }

    @Override
    public void send(NotificationEvent event) {

        emailService.send(event);

    }
}