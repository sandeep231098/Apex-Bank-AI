package com.apexbank.notification.service.impl;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.common.enums.NotificationStatus;
import com.apexbank.notification.dispatcher.NotificationDispatcher;
import com.apexbank.notification.entity.Notification;
import com.apexbank.notification.repository.NotificationRepository;
import com.apexbank.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.apexbank.common.enums.NotificationType;
import com.apexbank.notification.dto.request.TestEmailRequest;
import com.apexbank.common.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @Override
    public void sendTestEmail(TestEmailRequest request) {

        NotificationEvent event = NotificationEvent.builder()
                .recipient(request.getRecipient())
                .subject(request.getSubject())
                .notificationType(NotificationType.EMAIL)
                .templateName("generic-email")
                .variables(
                        Map.of(
                                "message",
                                request.getMessage()
                        ))
                .build();

        processNotification(event);
    }

    @Override
    public List<Notification> getAllNotifications() {

        return repository.findAll();

    }

    @Override
    public Notification getNotification(UUID id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Notification not found"));

    }

}