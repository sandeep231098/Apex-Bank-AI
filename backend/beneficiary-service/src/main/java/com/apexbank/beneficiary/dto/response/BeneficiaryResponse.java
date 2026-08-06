package com.apexbank.beneficiary.dto.response;

import com.apexbank.common.enums.BeneficiaryStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class BeneficiaryResponse {

    private UUID id;

    private UUID customerId;

    private String beneficiaryName;

    private String beneficiaryAccountNumber;

    private String beneficiaryIfsc;

    private String nickname;
    private UUID beneficiaryAccountId;
    private BeneficiaryStatus status;

    private Boolean verified;

    private LocalDateTime createdAt;
}