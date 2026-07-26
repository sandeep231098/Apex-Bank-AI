package com.apexbank.transaction.dto.request;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.common.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TransactionSearchRequest {

    private UUID accountId;

    private TransactionType transactionType;

    private TransactionStatus transactionStatus;

    private LocalDateTime fromDate;

    private LocalDateTime toDate;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;
}