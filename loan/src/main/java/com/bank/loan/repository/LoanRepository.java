package com.bank.loan.repository;


import com.bank.loan.domain.entity.Loan;
import com.bank.loan.dto.customer.ResponseLoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LoanRepository extends MongoRepository<Loan,String> {
    List<Loan> findByCustomerId(String customerId);

}
