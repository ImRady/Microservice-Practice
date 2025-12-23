package com.bank.loan.dto.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RequestLoan {

    @NotNull
    private String customerId;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private String loanType;
    @Positive
    private BigDecimal totalLoan;
    @Positive
    private BigDecimal amountPaid;
    @Positive
    private BigDecimal outstandingAmount;
    @NotNull
    private LocalDate createDate;
}
