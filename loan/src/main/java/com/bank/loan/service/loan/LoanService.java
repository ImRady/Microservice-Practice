package com.bank.loan.service.loan;

import com.bank.loan.domain.entity.Loan;

import java.util.List;

public interface LoanService {

    Loan saveLoan(Loan loan);
    List<Loan> getLoans();
    Loan getLoanById(String loanId);
}
