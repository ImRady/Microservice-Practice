package com.bank.account.controller;

import com.bank.account.domain.model.Account;
import com.bank.account.dto.account.AccountRequest;
import com.bank.account.dto.account.AccountResponse;
import com.bank.account.mapping.AccountMapper;
import com.bank.account.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @RequestBody AccountRequest accountRequest){

        Account account = accountService.createAccount(accountRequest);
        AccountResponse response = accountMapper.toResponse(account);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponse> getAccount(
            @PathVariable Long accountNumber){
        Account account = accountService.getAccount(accountNumber);
        AccountResponse response = accountMapper.toResponse(account);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<?> getAccounts(){
        return ResponseEntity.ok(accountService.getAccounts());
    }



}
