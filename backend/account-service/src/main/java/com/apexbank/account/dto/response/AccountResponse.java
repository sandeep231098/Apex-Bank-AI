package com.apexbank.account.dto.response;

import com.apexbank.common.enums.AccountStatus;
import com.apexbank.common.enums.AccountType;
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

    private UUID userId;

    private String accountNumber;

    private AccountType accountType;

    private AccountStatus accountStatus;

    private BigDecimal balance;

    private String currency;

    private String branchCode;

    private String ifscCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}