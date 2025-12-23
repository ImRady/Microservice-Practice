package com.bank.account.dto.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private String createDate;
}
