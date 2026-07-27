package com.apexbank.account.dto.response.balance;

import com.apexbank.common.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String currency;
    private AccountStatus accountStatus;
}