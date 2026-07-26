package com.apexbank.transaction.service;

import com.apexbank.transaction.dto.request.CreateTransactionRequest;
import com.apexbank.transaction.dto.request.TransferRequest;
import com.apexbank.transaction.dto.response.TransactionResponse;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    TransactionResponse deposit(CreateTransactionRequest request);

    TransactionResponse withdraw(CreateTransactionRequest request);

    TransactionResponse transfer(TransferRequest request);

    TransactionResponse getById(UUID id);

    List<TransactionResponse> getAll();

    List<TransactionResponse> getByAccount(UUID accountId);

    Page<TransactionResponse> getStatement(UUID accountId, Pageable pageable);
}