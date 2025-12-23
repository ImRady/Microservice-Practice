package com.bank.account.service.account;


import com.bank.account.domain.model.Account;
import com.bank.account.dto.account.AccountRequest;
import com.bank.account.mapping.AccountMapper;
import com.bank.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;


    @Override
    public Account createAccount(AccountRequest account) {

        Account savedAccount = accountMapper.toAccount(account);

        return accountRepository.save(savedAccount);
    }

    @Override
    public Account getAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(()-> new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
