package com.apexbank.notification.dto.response;

import com.apexbank.common.enums.NotificationStatus;
import com.apexbank.common.enums.NotificationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class NotificationResponse {

    private UUID id;

    private String recipient;

    private String subject;

    private String content;

    private NotificationType notificationType;

    private NotificationStatus status;

    private String errorMessage;

    private LocalDateTime createdAt;

    private LocalDateTime sentAt;

}