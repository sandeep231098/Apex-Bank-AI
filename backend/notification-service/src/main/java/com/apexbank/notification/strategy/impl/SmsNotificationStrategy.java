package com.apexbank.notification.strategy.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationType;
import com.apexbank.notification.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SmsNotificationStrategy
        implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }

    @Override
    public void send(NotificationEvent event) {

        // Twilio later

    }
}