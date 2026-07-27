package com.apexbank.transaction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction_request_logs")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String requestId;

    @Column(nullable = false)
    private UUID transactionId;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}