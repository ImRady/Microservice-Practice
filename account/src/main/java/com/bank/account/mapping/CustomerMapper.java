package com.bank.account.mapping;


import com.bank.account.domain.model.Customer;
import com.bank.account.dto.CustomerRequest;
import com.bank.account.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

     Customer toCustomer(CustomerRequest customer);
     CustomerResponse toCustomerResponse(Customer customer);
     List<CustomerResponse> toCustomerResponses(List<Customer> customers);
}
