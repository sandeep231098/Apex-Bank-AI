package com.apexbank.account.dto.response;

import com.apexbank.common.enums.AccountStatus;
import com.apexbank.common.enums.AccountType;
import com.apexbank.common.enums.CurrencyType;
import lombok.*;

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