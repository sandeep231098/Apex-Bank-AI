package com.apexbank.auth.kafka;

import com.apexbank.common.constants.KafkaTopics;
import com.apexbank.common.dto.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public void publish(NotificationEvent event) {

        kafkaTemplate.send(
                KafkaTopics.NOTIFICATION_TOPIC,
                event);

    }
}