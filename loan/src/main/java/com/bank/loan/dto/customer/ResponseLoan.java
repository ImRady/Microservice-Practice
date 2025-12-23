package com.bank.loan.dto.customer;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ResponseLoan {

    private String loanNumber;
    private String customerId;
    private LocalDate startDate;
    private String loanType;
    private BigDecimal totalLoan;
    private BigDecimal amountPaid;
    private BigDecimal outstandingAmount;
    private LocalDate createDate;
}
