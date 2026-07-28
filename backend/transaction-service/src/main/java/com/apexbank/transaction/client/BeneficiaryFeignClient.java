package com.apexbank.transaction.client;

import com.apexbank.transaction.client.dto.BeneficiaryAccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name = "account-service")
public interface BeneficiaryFeignClient {

    @GetMapping("/api/beneficiaries/internal/account-id")
    BeneficiaryAccountResponse getBeneficiaryAccount(

            @RequestParam UUID customerId,

            @RequestParam String accountNumber);

}