package com.apexbank.transaction.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatementSummaryResponse {

    private BigDecimal totalCredit;

    private BigDecimal totalDebit;

    private Long totalTransactions;

}