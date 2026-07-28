package com.apexbank.account.controller;

import com.apexbank.account.dto.request.AddBeneficiaryRequest;
import com.apexbank.account.dto.request.UpdateBeneficiaryRequest;
import com.apexbank.account.dto.response.BeneficiaryAccountResponse;
import com.apexbank.account.dto.response.BeneficiaryResponse;
import com.apexbank.account.service.BeneficiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {

    private final BeneficiaryService service;

    @PostMapping("/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public BeneficiaryResponse addBeneficiary(
            @PathVariable UUID customerId,
            @Valid @RequestBody AddBeneficiaryRequest request) {

        return service.addBeneficiary(customerId, request);
    }

    @GetMapping("/{customerId}")
    public List<BeneficiaryResponse> getBeneficiaries(
            @PathVariable UUID customerId) {

        return service.getBeneficiaries(customerId);
    }

    @GetMapping("/{customerId}/{beneficiaryId}")
    public BeneficiaryResponse getBeneficiary(
            @PathVariable UUID customerId,
            @PathVariable UUID beneficiaryId) {

        return service.getBeneficiary(customerId, beneficiaryId);
    }

    @PutMapping("/{customerId}/{beneficiaryId}")
    public BeneficiaryResponse updateBeneficiary(
            @PathVariable UUID customerId,
            @PathVariable UUID beneficiaryId,
            @Valid @RequestBody UpdateBeneficiaryRequest request) {

        return service.updateBeneficiary(
                customerId,
                beneficiaryId,
                request);
    }

    @DeleteMapping("/{customerId}/{beneficiaryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeneficiary(
            @PathVariable UUID customerId,
            @PathVariable UUID beneficiaryId) {

        service.deleteBeneficiary(customerId, beneficiaryId);
    }

    @PatchMapping("/{customerId}/{beneficiaryId}/verify")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void verifyBeneficiary(
            @PathVariable UUID customerId,
            @PathVariable UUID beneficiaryId) {

        service.verifyBeneficiary(customerId, beneficiaryId);
    }

    @GetMapping("/internal/validate")
    @ResponseStatus(HttpStatus.OK)
    public void validateBeneficiary(
            @RequestParam UUID customerId,
            @RequestParam String accountNumber) {

        service.validateBeneficiary(customerId, accountNumber);
    }

    @GetMapping("/internal/account-id")
    public BeneficiaryAccountResponse getBeneficiaryAccount(

            @RequestParam UUID customerId,

            @RequestParam String accountNumber) {

        return service.getBeneficiaryAccount(
                customerId,
                accountNumber);
    }
}