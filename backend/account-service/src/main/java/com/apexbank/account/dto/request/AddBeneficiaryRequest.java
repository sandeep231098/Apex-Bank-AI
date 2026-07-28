package com.apexbank.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBeneficiaryRequest {

    @NotBlank(message = "Beneficiary name is required")
    @Size(max = 150)
    private String beneficiaryName;

    @NotBlank(message = "Beneficiary account number is required")
    @Size(max = 30)
    private String beneficiaryAccountNumber;

    @NotBlank(message = "IFSC code is required")
    @Size(max = 20)
    private String beneficiaryIfsc;

    @Size(max = 100)
    private String nickname;
}