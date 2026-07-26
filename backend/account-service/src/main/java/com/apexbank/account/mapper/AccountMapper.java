package com.apexbank.account.mapper;

import com.apexbank.account.dto.request.CreateAccountRequest;
import com.apexbank.account.dto.request.UpdateAccountRequest;
import com.apexbank.account.dto.response.AccountResponse;
import com.apexbank.account.entity.Account;
import com.apexbank.common.enums.AccountStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccountMapper {

    public Account toEntity(CreateAccountRequest request) {

        return Account.builder()
                .userId(request.getUserId())
                .accountType(request.getAccountType())
                .balance(request.getOpeningBalance())
                .currency(request.getCurrency())
                .branchCode(request.getBranchCode())
                .ifscCode(request.getIfscCode())
                .accountStatus(AccountStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public AccountResponse toResponse(Account account) {

        return AccountResponse.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .accountStatus(account.getAccountStatus())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .branchCode(account.getBranchCode())
                .ifscCode(account.getIfscCode())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }

    public void update(UpdateAccountRequest request, Account account) {

        account.setAccountStatus(request.getAccountStatus());
        account.setBranchCode(request.getBranchCode());
        account.setIfscCode(request.getIfscCode());
        account.setUpdatedAt(LocalDateTime.now());
    }
}