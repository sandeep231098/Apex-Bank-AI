package com.apexbank.transaction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "daily_transfer_limits")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyTransferLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID accountId;

    @Column(nullable = false)
    private LocalDate transferDate;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal totalTransferred;
}