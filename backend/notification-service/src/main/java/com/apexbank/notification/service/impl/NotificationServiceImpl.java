package com.apexbank.notification.service.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationStatus;
import com.apexbank.notification.dispatcher.NotificationDispatcher;
import com.apexbank.notification.entity.Notification;
import com.apexbank.notification.repository.NotificationRepository;
import com.apexbank.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationDispatcher dispatcher;
    private final NotificationRepository repository;

    @Override
    public void processNotification(NotificationEvent event) {

        Notification notification = Notification.builder()
                .recipient(event.getRecipient())
                .subject(event.getSubject())
                .notificationType(event.getNotificationType())
                .status(NotificationStatus.PENDING)
                .build();

        repository.save(notification);

        try {

            dispatcher.dispatch(event);

            notification.setStatus(NotificationStatus.SENT);

        } catch (Exception ex) {

            notification.setStatus(NotificationStatus.FAILED);
            notification.setErrorMessage(ex.getMessage());

        }

        repository.save(notification);

    }

}