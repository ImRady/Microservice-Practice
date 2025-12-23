package com.bank.loan.service.loan;


import com.bank.loan.domain.entity.Loan;
import com.bank.loan.mapper.LoanMapper;
import com.bank.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{


    @Autowired
    private LoanRepository loanRepository;



    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan getLoanById(String loanId) {
        return loanRepository.findById(loanId).orElseThrow(()->
                 new RuntimeException("loan not found"));
    }


}
