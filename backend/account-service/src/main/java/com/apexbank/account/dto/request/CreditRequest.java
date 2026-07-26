package com.apexbank.account.dto.request;

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
public class CreditRequest {

    @NotNull
    private UUID accountId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;
}