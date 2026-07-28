package com.apexbank.notification.template;

import com.apexbank.common.dto.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailTemplateServiceImpl
        implements EmailTemplateService {

    private final TemplateEngine templateEngine;

    @Override
    public String process(NotificationEvent event) {

        Context context = new Context();

        if (event.getVariables() != null) {

            context.setVariables(event.getVariables());

        }

        return templateEngine.process(
                event.getTemplateName(),
                context
        );
    }

}