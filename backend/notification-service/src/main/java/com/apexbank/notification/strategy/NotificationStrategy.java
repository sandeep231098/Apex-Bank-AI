package com.apexbank.notification.strategy;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationType;

public interface NotificationStrategy {

    NotificationType getType();

    void send(NotificationEvent event);

}