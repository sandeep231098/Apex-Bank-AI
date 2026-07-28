package com.apexbank.common.dto;

import com.apexbank.common.enums.NotificationType;
import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent implements Serializable {

    private UUID eventId;

    private NotificationType notificationType;

    private String recipient;

    private String subject;

    private String templateName;

    /**
     * Dynamic placeholders for HTML templates.
     *
     * Example:
     * firstName -> Sandeep
     * resetLink -> https://...
     */
    private Map<String, Object> variables;
}