package com.apexbank.account.controller;

import com.apexbank.account.dto.request.*;
import com.apexbank.account.dto.response.AccountResponse;
import com.apexbank.account.dto.response.BalanceUpdateResponse;
import com.apexbank.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse create(
            @Valid @RequestBody CreateAccountRequest request) {

        return service.create(request);
    }

    @PostMapping("/deposit")
    public AccountResponse deposit(
            @Valid @RequestBody DepositRequest request) {

        return service.deposit(request);
    }

    @PostMapping("/withdraw")
    public AccountResponse withdraw(
            @Valid @RequestBody WithdrawRequest request) {

        return service.withdraw(request);
    }
    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transfer(
            @Valid @RequestBody TransferMoneyRequest request) {

        service.transfer(request);
    }

    @PostMapping("/internal/debit")
    public BalanceUpdateResponse debit(
            @Valid @RequestBody DebitRequest request) {

        return service.debit(request);
    }

    @PostMapping("/internal/credit")
    public BalanceUpdateResponse credit(
            @Valid @RequestBody CreditRequest request) {

        return service.credit(request);
    }

    @GetMapping("/{id}")
    public AccountResponse getById(@PathVariable UUID id) {

        return service.getById(id);
    }

    @GetMapping
    public List<AccountResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<AccountResponse> getByUserId(
            @PathVariable UUID userId) {

        return service.getByUserId(userId);
    }

    @PutMapping("/{id}")
    public AccountResponse update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateAccountRequest request) {

        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {

        service.delete(id);
    }
}