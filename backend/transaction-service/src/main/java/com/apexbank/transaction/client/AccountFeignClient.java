package com.apexbank.transaction.client;

import com.apexbank.transaction.client.dto.AccountResponse;
import com.apexbank.transaction.client.dto.BalanceUpdateResponse;
import com.apexbank.transaction.client.dto.CreditRequest;
import com.apexbank.transaction.client.dto.DebitRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "account-service")
public interface AccountFeignClient {

    @GetMapping("/api/accounts/internal/{accountId}")
    AccountResponse getAccount(

            @PathVariable("accountId") UUID accountId

    );

    @PostMapping("/api/accounts/internal/debit")
    BalanceUpdateResponse debit(

            @RequestBody DebitRequest request

    );

    @PostMapping("/api/accounts/internal/credit")
    BalanceUpdateResponse credit(

            @RequestBody CreditRequest request

    );
}