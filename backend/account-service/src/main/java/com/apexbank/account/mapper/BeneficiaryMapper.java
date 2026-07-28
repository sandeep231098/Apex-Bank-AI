package com.apexbank.account.mapper;

import com.apexbank.account.dto.request.AddBeneficiaryRequest;
import com.apexbank.account.dto.request.UpdateBeneficiaryRequest;
import com.apexbank.account.dto.response.BeneficiaryResponse;
import com.apexbank.account.entity.Beneficiary;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryMapper {

    public Beneficiary toEntity(AddBeneficiaryRequest request) {

        Beneficiary beneficiary = new Beneficiary();

        beneficiary.setBeneficiaryName(request.getBeneficiaryName());
        beneficiary.setBeneficiaryAccountNumber(request.getBeneficiaryAccountNumber());
        beneficiary.setBeneficiaryIfsc(request.getBeneficiaryIfsc());
        beneficiary.setNickname(request.getNickname());
        beneficiary.setBeneficiaryAccountId(
                request.getBeneficiaryAccountId());
        return beneficiary;
    }

    public BeneficiaryResponse toResponse(Beneficiary beneficiary) {

        return BeneficiaryResponse.builder()
                .id(beneficiary.getId())
                .customerId(beneficiary.getCustomerId())
                .beneficiaryName(beneficiary.getBeneficiaryName())
                .beneficiaryAccountNumber(beneficiary.getBeneficiaryAccountNumber())
                .beneficiaryIfsc(beneficiary.getBeneficiaryIfsc())
                .nickname(beneficiary.getNickname())
                .status(beneficiary.getStatus())
                .verified(beneficiary.getVerified())
                .createdAt(beneficiary.getCreatedAt())
                .beneficiaryAccountId(
                        beneficiary.getBeneficiaryAccountId())
                .build();
    }

    public void updateEntity(
            Beneficiary beneficiary,
            UpdateBeneficiaryRequest request) {

        beneficiary.setBeneficiaryName(request.getBeneficiaryName());
        beneficiary.setBeneficiaryIfsc(request.getBeneficiaryIfsc());
        beneficiary.setNickname(request.getNickname());

    }

}