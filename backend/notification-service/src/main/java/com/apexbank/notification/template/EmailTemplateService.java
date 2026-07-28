package com.apexbank.notification.template;

import com.apexbank.common.dto.NotificationEvent;

public interface EmailTemplateService {

    String process(NotificationEvent event);

}