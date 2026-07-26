package com.apexbank.transaction.mapper;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.transaction.dto.request.CreateTransactionRequest;
import com.apexbank.transaction.dto.response.TransactionResponse;
import com.apexbank.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public Transaction toEntity(CreateTransactionRequest request) {

        return Transaction.builder()
                .fromAccountId(request.getFromAccountId())
                .toAccountId(request.getToAccountId())
                .transactionType(request.getTransactionType())
                .transactionStatus(TransactionStatus.SUCCESS)
                .amount(request.getAmount())
                .remarks(request.getRemarks())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public TransactionResponse toResponse(Transaction transaction) {

        return TransactionResponse.builder()
                .id(transaction.getId())
                .transactionReference(transaction.getTransactionReference())
                .fromAccountId(transaction.getFromAccountId())
                .toAccountId(transaction.getToAccountId())
                .transactionType(transaction.getTransactionType())
                .transactionStatus(transaction.getTransactionStatus())
                .amount(transaction.getAmount())
                .remarks(transaction.getRemarks())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
}