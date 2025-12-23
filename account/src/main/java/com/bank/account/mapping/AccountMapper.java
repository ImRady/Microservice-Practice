package com.bank.account.mapping;


import com.bank.account.domain.model.Account;
import com.bank.account.dto.account.AccountRequest;
import com.bank.account.dto.account.AccountResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {


    Account toAccount(AccountRequest accountRequest);
    AccountResponse toResponse(Account account);

}
