package com.apexbank.transaction.dto.response;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.common.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private UUID id;

    private String transactionReference;

    private UUID fromAccountId;

    private UUID toAccountId;

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private BigDecimal amount;

    private String remarks;

    private LocalDateTime createdAt;

}