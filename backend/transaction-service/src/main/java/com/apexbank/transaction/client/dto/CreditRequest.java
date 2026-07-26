package com.apexbank.transaction.client.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequest {

    private UUID accountId;

    private BigDecimal amount;

}