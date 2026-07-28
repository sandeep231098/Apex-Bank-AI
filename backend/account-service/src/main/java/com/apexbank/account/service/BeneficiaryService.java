package com.apexbank.account.service;

import com.apexbank.account.dto.request.AddBeneficiaryRequest;
import com.apexbank.account.dto.request.UpdateBeneficiaryRequest;
import com.apexbank.account.dto.response.BeneficiaryAccountResponse;
import com.apexbank.account.dto.response.BeneficiaryResponse;

import java.util.List;
import java.util.UUID;

public interface BeneficiaryService {

    BeneficiaryResponse addBeneficiary(
            UUID customerId,
            AddBeneficiaryRequest request);

    List<BeneficiaryResponse> getBeneficiaries(
            UUID customerId);

    BeneficiaryResponse getBeneficiary(
            UUID customerId,
            UUID beneficiaryId);

    BeneficiaryResponse updateBeneficiary(
            UUID customerId,
            UUID beneficiaryId,
            UpdateBeneficiaryRequest request);

    void deleteBeneficiary(
            UUID customerId,
            UUID beneficiaryId);

    void verifyBeneficiary(
            UUID customerId,
            UUID beneficiaryId);

    void validateBeneficiary(
            UUID customerId,
            String beneficiaryAccountNumber);

    BeneficiaryAccountResponse getBeneficiaryAccount(
            UUID customerId,
            String beneficiaryAccountNumber);
}