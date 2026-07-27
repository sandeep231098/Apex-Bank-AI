package com.apexbank.account.service;

import com.apexbank.account.dto.request.*;
import com.apexbank.account.dto.response.AccountResponse;
import com.apexbank.account.dto.response.BalanceUpdateResponse;
import com.apexbank.account.dto.response.balance.BalanceResponse;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountResponse create(CreateAccountRequest request);

    AccountResponse getById(UUID id);

    List<AccountResponse> getByUserId(UUID userId);

    List<AccountResponse> getAll();

    AccountResponse update(UUID id, UpdateAccountRequest request);

    void delete(UUID id);

    AccountResponse deposit(DepositRequest request);

    AccountResponse withdraw(WithdrawRequest request);

    void transfer(TransferMoneyRequest request);

    BalanceUpdateResponse debit(DebitRequest request);

    BalanceUpdateResponse credit(CreditRequest request);

    BalanceResponse getBalance(UUID accountId);

    AccountResponse changeAccountStatus(UUID accountId,
                                        FreezeAccountRequest request);
}