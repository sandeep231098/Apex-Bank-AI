package com.apexbank.notification.strategy.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationType;
import com.apexbank.notification.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PushNotificationStrategy
        implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }

    @Override
    public void send(NotificationEvent event) {

        // Firebase later

    }
}