package com.apexbank.transaction.client.dto;

import com.apexbank.common.enums.AccountStatus;
import com.apexbank.common.enums.AccountType;
import com.apexbank.common.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {

    private UUID id;

    private UUID customerId;

    private String accountNumber;

    private AccountType accountType;

    private AccountStatus status;

    private BigDecimal balance;

    private CurrencyType currency;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}