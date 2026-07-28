package com.apexbank.account.service.impl;

import com.apexbank.account.dto.request.AddBeneficiaryRequest;
import com.apexbank.account.dto.request.UpdateBeneficiaryRequest;
import com.apexbank.account.dto.response.BeneficiaryAccountResponse;
import com.apexbank.account.dto.response.BeneficiaryResponse;
import com.apexbank.account.entity.Beneficiary;
import com.apexbank.account.mapper.BeneficiaryMapper;
import com.apexbank.account.repository.BeneficiaryRepository;
import com.apexbank.account.service.BeneficiaryService;
import com.apexbank.common.enums.BeneficiaryStatus;
import com.apexbank.common.exception.BusinessException;
import com.apexbank.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

    private final BeneficiaryRepository repository;
    private final BeneficiaryMapper mapper;

    @Override
    public BeneficiaryResponse addBeneficiary(
            UUID customerId,
            AddBeneficiaryRequest request) {

        boolean exists = repository
                .existsByCustomerIdAndBeneficiaryAccountNumber(
                        customerId,
                        request.getBeneficiaryAccountNumber());

        if (exists) {

            throw new BusinessException(
                    "Beneficiary already exists");
        }

        Beneficiary beneficiary = mapper.toEntity(request);

        beneficiary.setCustomerId(customerId);

        beneficiary.setStatus(BeneficiaryStatus.PENDING);

        beneficiary.setVerified(false);

        Beneficiary saved = repository.save(beneficiary);

        return mapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BeneficiaryResponse> getBeneficiaries(UUID customerId) {

        return repository.findByCustomerId(customerId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BeneficiaryResponse getBeneficiary(
            UUID customerId,
            UUID beneficiaryId) {

        Beneficiary beneficiary = repository
                .findByIdAndCustomerId(beneficiaryId, customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Beneficiary not found"));

        return mapper.toResponse(beneficiary);
    }

    @Override
    public BeneficiaryResponse updateBeneficiary(
            UUID customerId,
            UUID beneficiaryId,
            UpdateBeneficiaryRequest request) {

        Beneficiary beneficiary = repository
                .findByIdAndCustomerId(beneficiaryId, customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Beneficiary not found"));

        if (beneficiary.getStatus() == BeneficiaryStatus.DELETED) {
            throw new BusinessException("Deleted beneficiary cannot be updated");
        }

        mapper.updateEntity(beneficiary, request);

        Beneficiary updated = repository.save(beneficiary);

        return mapper.toResponse(updated);
    }

    @Override
    public void deleteBeneficiary(
            UUID customerId,
            UUID beneficiaryId) {

        Beneficiary beneficiary = repository
                .findByIdAndCustomerId(beneficiaryId, customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Beneficiary not found"));

        beneficiary.setStatus(BeneficiaryStatus.DELETED);

        repository.save(beneficiary);
    }

    @Override
    public void verifyBeneficiary(
            UUID customerId,
            UUID beneficiaryId) {

        Beneficiary beneficiary = repository
                .findByIdAndCustomerId(beneficiaryId, customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Beneficiary not found"));

        beneficiary.setVerified(true);
        beneficiary.setStatus(BeneficiaryStatus.ACTIVE);

        repository.save(beneficiary);
    }
    @Override
    @Transactional(readOnly = true)
    public void validateBeneficiary(
            UUID customerId,
            String beneficiaryAccountNumber) {

        repository.findByCustomerIdAndBeneficiaryAccountNumberAndStatus(
                        customerId,
                        beneficiaryAccountNumber,
                        BeneficiaryStatus.ACTIVE)
                .orElseThrow(() ->
                        new BusinessException("Beneficiary not found or inactive"));
    }
    @Override
    @Transactional(readOnly = true)
    public BeneficiaryAccountResponse getBeneficiaryAccount(
            UUID customerId,
            String beneficiaryAccountNumber) {

        Beneficiary beneficiary = repository
                .findByCustomerIdAndBeneficiaryAccountNumberAndStatus(
                        customerId,
                        beneficiaryAccountNumber,
                        BeneficiaryStatus.ACTIVE)
                .orElseThrow(() ->
                        new BusinessException("Beneficiary not found"));

        return BeneficiaryAccountResponse.builder()
                .beneficiaryAccountId(
                        beneficiary.getBeneficiaryAccountId())
                .build();
    }
}