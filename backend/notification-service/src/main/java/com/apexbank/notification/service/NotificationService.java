package com.apexbank.notification.service;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.notification.dto.request.TestEmailRequest;
import com.apexbank.notification.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    void processNotification(NotificationEvent event);

    void sendTestEmail(TestEmailRequest request);

    List<Notification> getAllNotifications();

    Notification getNotification(UUID id);

}