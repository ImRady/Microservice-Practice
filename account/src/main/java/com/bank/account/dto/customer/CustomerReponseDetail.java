package com.bank.account.dto.customer;


import com.bank.account.dto.card.CardResponse;
import com.bank.account.dto.loan.LoanResponse;
import lombok.Data;

import java.util.List;

@Data
public class CustomerReponseDetail {
    private CustomerResponse customer;
    private List<LoanResponse> loans;
    private List<CardResponse> cards;

}
