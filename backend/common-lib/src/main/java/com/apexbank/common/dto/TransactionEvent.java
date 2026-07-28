package com.apexbank.common.dto;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.common.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {

        private UUID transactionId;

        private String reference;

        private UUID fromAccountId;

        private UUID toAccountId;

        private BigDecimal amount;

        private TransactionType transactionType;

        private TransactionStatus transactionStatus;

        private LocalDateTime createdAt;
    }

