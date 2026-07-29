package com.apexbank.transaction.kafka;

import com.apexbank.common.constants.KafkaTopics;
import com.apexbank.common.dto.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionProducer {

    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public void publish(TransactionEvent event) {

        kafkaTemplate.send(
                KafkaTopics.TRANSACTION_TOPIC,

                event.getTransactionId().toString(),
                event
        );
    }
}