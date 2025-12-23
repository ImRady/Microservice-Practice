package com.bank.loan.mapper;

import com.bank.loan.domain.entity.Loan;
import com.bank.loan.dto.customer.RequestLoan;
import com.bank.loan.dto.customer.ResponseLoan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface LoanMapper {

    @Mapping(target ="loanNumber",ignore = true)
    Loan toLoan(RequestLoan requestLoan);

    ResponseLoan toResponseLoan(Loan loan);

}
