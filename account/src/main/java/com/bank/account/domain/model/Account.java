package com.bank.account.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "accounts")
@Data
public class Account {


    @Id
    private Long accountNumber;

    private String customerId;
    private String accountType;
    private String branchAddress;
    private LocalDate createdDate;

}
