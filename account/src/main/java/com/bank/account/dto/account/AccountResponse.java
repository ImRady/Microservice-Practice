package com.bank.account.dto.account;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AccountResponse {

    private String accountNumber;
    private String customerId;
    private String accountType;
    private LocalDate createdDate;
}
