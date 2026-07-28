package com.apexbank.account.dto.response.balance;

import com.apexbank.common.enums.AccountStatus;
import com.apexbank.common.enums.CurrencyType;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceResponse {

    private UUID accountId;

    private String accountNumber;

    private BigDecimal availableBalance;

    private CurrencyType currency;

    private AccountStatus status;
}