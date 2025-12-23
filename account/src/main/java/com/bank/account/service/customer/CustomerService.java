package com.bank.account.service.customer;

import com.bank.account.domain.model.Customer;
import com.bank.account.dto.customer.CustomerRequest;

import java.util.List;

public interface CustomerService {

    Customer save(CustomerRequest customer);
    List<Customer>getCustomers();
    Customer getByCustomerId(String customerId);
}
