package com.apexbank.account.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceUpdateResponse {

    private UUID accountId;

    private String accountNumber;

    private BigDecimal balance;

    private String message;
}