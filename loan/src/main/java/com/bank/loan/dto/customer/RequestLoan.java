package com.bank.loan.dto.customer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestLoan {

    private Long customerId;
    private LocalDate startDate;
    private String loanType;
    private BigDecimal totalLoan;
    private BigDecimal amountPaid;
    private BigDecimal outstandingAmount;
    private LocalDate createDate;
}
