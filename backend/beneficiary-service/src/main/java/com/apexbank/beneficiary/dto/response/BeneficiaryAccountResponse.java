package com.apexbank.beneficiary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryAccountResponse {

    private UUID beneficiaryId;

    private UUID beneficiaryAccountId;

    private String beneficiaryAccountNumber;

    private String beneficiaryName;

}