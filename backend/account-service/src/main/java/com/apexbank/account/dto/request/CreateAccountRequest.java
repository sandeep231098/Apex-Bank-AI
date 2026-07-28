package com.apexbank.account.dto.request;

import com.apexbank.common.enums.AccountType;
import com.apexbank.common.enums.CurrencyType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {

    @NotNull(message = "Customer Id is required")
    private UUID customerId;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @NotNull(message = "Currency is required")
    private CurrencyType currency;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal openingBalance;
}