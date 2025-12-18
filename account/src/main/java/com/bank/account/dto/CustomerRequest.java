package com.bank.account.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {

    private String name;
    private String email;
    private String mobileNumber;
    private String createDate;

}
