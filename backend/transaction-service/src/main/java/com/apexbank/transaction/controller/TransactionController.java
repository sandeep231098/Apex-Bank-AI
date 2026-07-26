package com.apexbank.transaction.controller;

import com.apexbank.transaction.dto.request.CreateTransactionRequest;
import com.apexbank.transaction.dto.request.TransferRequest;
import com.apexbank.transaction.dto.response.TransactionResponse;
import com.apexbank.transaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse deposit(@Valid @RequestBody CreateTransactionRequest request) {
        return service.deposit(request);
    }

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse withdraw(@Valid @RequestBody CreateTransactionRequest request) {
        return service.withdraw(request);
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public TransactionResponse transfer(@Valid @RequestBody TransferRequest request) {
        return service.transfer(request);
    }

    @GetMapping("/account/{accountId}/statement")
    public Page<TransactionResponse> getStatement(
            @PathVariable UUID accountId,
            @PageableDefault(size = 10, sort = "createdAt")
            Pageable pageable) {

        return service.getStatement(accountId, pageable);
    }

    @GetMapping("/{id}")
    public TransactionResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<TransactionResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionResponse> getByAccount(@PathVariable UUID accountId) {
        return service.getByAccount(accountId);
    }
}