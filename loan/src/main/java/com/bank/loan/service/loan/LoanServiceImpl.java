package com.bank.loan.service.loan;


import com.bank.loan.domain.entity.Loan;
import com.bank.loan.dto.customer.ResponseLoan;
import com.bank.loan.mapper.LoanMapper;
import com.bank.loan.repository.LoanRepository;
import com.bank.loan.service.customer.CustomerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService{



    private final LoanRepository loanRepository;


    private final CustomerFeignClient customerFeignClient;


    private final LoanMapper loanMapper;


    @Override
    public Loan saveLoan(Loan loan) {
        Boolean exists = customerFeignClient.existsById(loan.getCustomerId());
        if(Boolean.FALSE.equals(exists)) {
            throw new RuntimeException("Customer not found");
        }

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

    @Override
    public List<Loan> getLoansByCustomerId(String customerId) {
        return  loanRepository.findByCustomerId(customerId);
    }


}
