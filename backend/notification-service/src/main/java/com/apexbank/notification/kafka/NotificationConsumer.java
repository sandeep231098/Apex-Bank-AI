package com.apexbank.notification.kafka;

import  com.apexbank.common.constants.KafkaTopics;
import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = KafkaTopics.NOTIFICATION_TOPIC,
            groupId = "notification-group"
    )
    public void consume(NotificationEvent event) {

        log.info(
                "Received notification for {}",
                event.getRecipient());

        try {

            notificationService.processNotification(event);

            log.info(
                    "Notification processed successfully");

        } catch (Exception ex) {

            log.error(
                    "Notification processing failed",
                    ex);

        }

    }
}