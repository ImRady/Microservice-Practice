package com.bank.account.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomerResponse {
    private String customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private String createDate;
}
