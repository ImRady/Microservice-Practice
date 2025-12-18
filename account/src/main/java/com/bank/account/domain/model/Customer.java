package com.bank.account.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "customers")
@Data
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDate;

}

