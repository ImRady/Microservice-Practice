package com.bank.account.service.account;


import com.bank.account.domain.model.Account;
import com.bank.account.dto.account.AccountRequest;

import java.util.List;

public interface AccountService {

    Account createAccount(AccountRequest account);
    Account getAccount(Long accountNumber);
    List<Account> getAccounts();
}
