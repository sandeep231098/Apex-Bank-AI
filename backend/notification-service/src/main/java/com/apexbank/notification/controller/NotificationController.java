package com.apexbank.notification.controller;

import com.apexbank.notification.dto.request.TestEmailRequest;
import com.apexbank.notification.dto.response.NotificationResponse;
import com.apexbank.notification.mapper.NotificationMapper;
import com.apexbank.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;
    private final NotificationMapper mapper;

    @GetMapping
    public List<NotificationResponse> getAllNotifications() {

        return service.getAllNotifications()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public NotificationResponse getNotification(
            @PathVariable UUID id) {

        return mapper.toResponse(
                service.getNotification(id));
    }

    @PostMapping("/test-email")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> sendTestEmail(
            @Valid @RequestBody TestEmailRequest request) {

        service.sendTestEmail(request);

        return Map.of(
                "message",
                "Test email sent successfully");
    }

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
                "service", "notification-service",
                "status", "UP");
    }

}