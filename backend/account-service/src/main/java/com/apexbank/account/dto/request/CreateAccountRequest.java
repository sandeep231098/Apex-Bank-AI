package com.apexbank.account.dto.request;

import com.apexbank.common.enums.AccountType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
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

    @NotNull(message = "User Id is required")
    private UUID userId;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @NotBlank(message = "Currency is required")
    private String currency;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal openingBalance;

    @NotBlank(message = "Branch code is required")
    private String branchCode;

    @NotBlank(message = "IFSC code is required")
    private String ifscCode;
}