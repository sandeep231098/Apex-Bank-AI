package com.apexbank.notification.service;

import com.apexbank.common.dto.NotificationEvent;

public interface EmailService {

    void send(NotificationEvent event);

}