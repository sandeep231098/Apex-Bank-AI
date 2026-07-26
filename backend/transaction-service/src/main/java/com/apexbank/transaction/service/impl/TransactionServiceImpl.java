package com.apexbank.transaction.service.impl;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.common.enums.TransactionType;
import com.apexbank.common.exception.ResourceNotFoundException;
import com.apexbank.transaction.client.AccountFeignClient;
import com.apexbank.transaction.client.dto.CreditRequest;
import com.apexbank.transaction.client.dto.DebitRequest;
import com.apexbank.transaction.dto.request.CreateTransactionRequest;
import com.apexbank.transaction.dto.request.TransferRequest;
import com.apexbank.transaction.dto.response.TransactionResponse;
import com.apexbank.transaction.entity.Transaction;
import com.apexbank.transaction.mapper.TransactionMapper;
import com.apexbank.transaction.repository.TransactionRepository;
import com.apexbank.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;
    private final AccountFeignClient accountFeignClient;

    @Override
    @Transactional
    public TransactionResponse deposit(CreateTransactionRequest request) {

        CreditRequest creditRequest = CreditRequest.builder()
                .accountId(request.getFromAccountId())
                .amount(request.getAmount())
                .build();

        accountFeignClient.credit(creditRequest);

        Transaction transaction = mapper.toEntity(request);
        transaction.setTransactionReference(generateReference());
        transaction.setCreatedAt(LocalDateTime.now());

        Transaction saved = repository.save(transaction);

        return mapper.toResponse(saved);
    }

    @Override
    @Transactional
    public TransactionResponse withdraw(CreateTransactionRequest request) {

        DebitRequest debitRequest = DebitRequest.builder()
                .accountId(request.getFromAccountId())
                .amount(request.getAmount())
                .build();

        accountFeignClient.debit(debitRequest);

        Transaction transaction = mapper.toEntity(request);
        transaction.setTransactionReference(generateReference());
        transaction.setCreatedAt(LocalDateTime.now());

        Transaction saved = repository.save(transaction);

        return mapper.toResponse(saved);
    }

    @Override
    @Transactional
    public TransactionResponse transfer(TransferRequest request) {

        DebitRequest debitRequest = DebitRequest.builder()
                .accountId(request.getFromAccountId())
                .amount(request.getAmount())
                .build();

        accountFeignClient.debit(debitRequest);

        CreditRequest creditRequest = CreditRequest.builder()
                .accountId(request.getToAccountId())
                .amount(request.getAmount())
                .build();

        accountFeignClient.credit(creditRequest);

        Transaction transaction = Transaction.builder()
                .transactionReference(generateReference())
                .fromAccountId(request.getFromAccountId())
                .toAccountId(request.getToAccountId())
                .transactionType(TransactionType.TRANSFER)
                .transactionStatus(TransactionStatus.SUCCESS)
                .amount(request.getAmount())
                .remarks(request.getRemarks())
                .createdAt(LocalDateTime.now())
                .build();

        Transaction saved = repository.save(transaction);

        return mapper.toResponse(saved);
    }

    @Override
    public TransactionResponse getById(UUID id) {

        Transaction transaction = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Transaction not found"));

        return mapper.toResponse(transaction);
    }

    @Override
    public List<TransactionResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<TransactionResponse> getByAccount(UUID accountId) {

        return repository.findByFromAccountId(accountId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    private String generateReference() {

        Random random = new Random();

        String reference;

        do {
            reference = "TXN"
                    + (1000000000L + Math.abs(random.nextLong()) % 9000000000L);

        } while (repository.existsByTransactionReference(reference));

        return reference;

    }
    @Override
    public Page<TransactionResponse> getStatement(
            UUID accountId,
            Pageable pageable) {

        return repository
                .findByFromAccountIdOrderByCreatedAtDesc(accountId, pageable)
                .map(mapper::toResponse);
    }

}