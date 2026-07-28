package com.apexbank.account.service.impl;

import com.apexbank.account.dto.request.*;
import com.apexbank.account.dto.response.AccountResponse;
import com.apexbank.account.dto.response.BalanceUpdateResponse;
import com.apexbank.account.dto.response.balance.BalanceResponse;
import com.apexbank.account.entity.Account;
import com.apexbank.account.mapper.AccountMapper;
import com.apexbank.account.repository.AccountRepository;
import com.apexbank.account.service.AccountService;
import com.apexbank.common.enums.AccountStatus;
import com.apexbank.common.exception.BusinessException;
import com.apexbank.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    @Override
    public AccountResponse create(CreateAccountRequest request) {

        Account account = mapper.toEntity(request);

        account.setAccountNumber(generateAccountNumber());

        Account saved = repository.save(account);

        return mapper.toResponse(saved);
    }

    @Override
    public AccountResponse getById(UUID id) {

        Account account = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        return mapper.toResponse(account);
    }

    @Override
    public List<AccountResponse> getByUserId(UUID userId) {

        return repository.findByCustomerId(userId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<AccountResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public AccountResponse update(UUID id,
                                  UpdateAccountRequest request) {

        Account account = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        mapper.update(request, account);

        Account updated = repository.save(account);

        return mapper.toResponse(updated);
    }

    @Override
    public void delete(UUID id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Account not found");
        }

        repository.deleteById(id);
    }

    @Override
    @Transactional
    public AccountResponse deposit(DepositRequest request) {

        Account account = repository.findById(request.getAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Account is not active");
        }

        account.setBalance(account.getBalance().add(request.getAmount()));

        Account updated = repository.save(account);

        return mapper.toResponse(updated);
    }

    @Override
    @Transactional
    public AccountResponse withdraw(WithdrawRequest request) {

        Account account = repository.findById(request.getAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Account is not active");
        }

        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            throw new BusinessException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(request.getAmount()));

        Account updated = repository.save(account);

        return mapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void transfer(TransferMoneyRequest request) {

        Account fromAccount = repository.findById(request.getFromAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Sender account not found"));

        Account toAccount = repository.findById(request.getToAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Receiver account not found"));

        if (fromAccount.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Sender account is not active");
        }

        if (toAccount.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Receiver account is not active");
        }

        if (fromAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new BusinessException("Insufficient balance");
        }

        fromAccount.setBalance(
                fromAccount.getBalance().subtract(request.getAmount()));

        toAccount.setBalance(
                toAccount.getBalance().add(request.getAmount()));

        repository.save(fromAccount);
        repository.save(toAccount);
    }

    @Override
    @Transactional
    public BalanceUpdateResponse debit(DebitRequest request) {

        Account account = repository.findById(request.getAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Account is not active");
        }

        if (account.getBalance().compareTo(request.getAmount()) < 0) {
            throw new BusinessException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(request.getAmount()));

        repository.save(account);

        return BalanceUpdateResponse.builder()
                .accountId(account.getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .message("Debit successful")
                .build();
    }

    @Override
    @Transactional
    public BalanceUpdateResponse credit(CreditRequest request) {

        Account account = repository.findById(request.getAccountId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BusinessException("Account is not active");
        }

        account.setBalance(account.getBalance().add(request.getAmount()));

        repository.save(account);

        return BalanceUpdateResponse.builder()
                .accountId(account.getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .message("Credit successful")
                .build();
    }

    @Override
    public BalanceResponse getBalance(UUID accountId) {

        Account account = repository.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        return BalanceResponse.builder()
                .accountId(account.getId())
                .accountNumber(account.getAccountNumber())
                .availableBalance(account.getBalance())
                .currency(account.getCurrency())
                .status(account.getStatus())
                .build();
    }

    @Override
    @Transactional
    public AccountResponse changeAccountStatus(
            UUID accountId,
            FreezeAccountRequest request) {

        Account account = repository.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account not found"));

        account.setStatus(request.getAccountStatus());

        Account updated = repository.save(account);

        return mapper.toResponse(updated);
    }

    private String generateAccountNumber() {

        Random random = new Random();

        String accountNumber;

        do {

            accountNumber = String.valueOf(
                    100000000000L +
                            (Math.abs(random.nextLong()) % 900000000000L));

        } while (repository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }
}