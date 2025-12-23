package com.bank.loan.controller;


import com.bank.loan.domain.entity.Loan;
import com.bank.loan.dto.customer.RequestLoan;
import com.bank.loan.dto.customer.ResponseLoan;
import com.bank.loan.mapper.LoanMapper;
import com.bank.loan.service.loan.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;
    @Autowired
    private LoanMapper loanMapper;


    @PostMapping
    public ResponseEntity<?>saveLoan(@Valid @RequestBody RequestLoan requestLoan) {

        Loan savedLoan = loanService.saveLoan(loanMapper.toLoan(requestLoan));

        ResponseLoan responseLoan = loanMapper.toResponseLoan(savedLoan);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseLoan);

    }

    @GetMapping
    public ResponseEntity<?> getLoans() {

        return ResponseEntity.ok(loanMapper.toResponseLoans(loanService.getLoans()));

    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getLoansByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(
                loanMapper.toResponseLoan(loanService.getLoanById(customerId)));
    }
}
