package com.bank.loan.controller;


import com.bank.loan.domain.entity.Loan;
import com.bank.loan.dto.customer.RequestLoan;
import com.bank.loan.service.loan.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    public ResponseEntity<?>saveLoan(@RequestBody RequestLoan loan){

        return null;

    }
}
