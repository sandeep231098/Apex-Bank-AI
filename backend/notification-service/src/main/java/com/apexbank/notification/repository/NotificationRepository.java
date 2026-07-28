package com.apexbank.notification.repository;

import com.apexbank.notification.entity.Notification;
import com.apexbank.common.enums.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository
        extends JpaRepository<Notification, UUID> {

    List<Notification> findByStatus(NotificationStatus status);

}