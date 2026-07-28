package com.apexbank.account.mapper;

import com.apexbank.account.dto.request.CreateAccountRequest;
import com.apexbank.account.dto.request.UpdateAccountRequest;
import com.apexbank.account.dto.response.AccountResponse;
import com.apexbank.account.entity.Account;
import com.apexbank.common.enums.AccountStatus;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity(CreateAccountRequest request) {

        return Account.builder()
                .customerId(request.getCustomerId())
                .accountType(request.getAccountType())
                .currency(request.getCurrency())
                .balance(request.getOpeningBalance())
                .status(AccountStatus.ACTIVE)
                .build();
    }

    public AccountResponse toResponse(Account account) {

        return AccountResponse.builder()
                .id(account.getId())
                .customerId(account.getCustomerId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .status(account.getStatus())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }

    public void update(UpdateAccountRequest request,
                       Account account) {

        account.setStatus(request.getStatus());
    }
}