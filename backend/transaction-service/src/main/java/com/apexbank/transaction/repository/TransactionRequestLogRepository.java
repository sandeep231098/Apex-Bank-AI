package com.apexbank.transaction.repository;

import com.apexbank.transaction.entity.TransactionRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRequestLogRepository
        extends JpaRepository<TransactionRequestLog, UUID> {

    Optional<TransactionRequestLog> findByRequestId(String requestId);
}