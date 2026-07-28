package com.apexbank.notification.dispatcher;

import com.apexbank.common.dto.NotificationEvent;
import com.apexbank.notification.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationDispatcher {

    private final List<NotificationStrategy> strategies;

    public NotificationDispatcher(
            List<NotificationStrategy> strategies) {

        this.strategies = strategies;
    }

    public void dispatch(NotificationEvent event) {

        strategies.stream()

                .filter(strategy ->
                        strategy.getType() ==
                                event.getNotificationType())

                .findFirst()

                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No notification strategy found"))

                .send(event);
    }
}