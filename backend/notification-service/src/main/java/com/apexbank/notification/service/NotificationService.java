package com.apexbank.notification.service;

import com.apexbank.common.dto.NotificationEvent;

public interface NotificationService {

    void processNotification(NotificationEvent event);

}