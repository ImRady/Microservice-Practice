package com.bank.account.service.customer;

import com.bank.account.domain.model.Customer;
import com.bank.account.dto.CustomerRequest;

import com.bank.account.mapping.CustomerMapper;

import com.bank.account.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public Customer save(CustomerRequest customer) {
        Customer newCustomer = customerMapper.toCustomer(customer);
        return customerRepository.save(newCustomer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getByCustomerId(String customerId) {
        return customerRepository.findById(customerId).
                orElseThrow(()-> new RuntimeException("Customer not found with id: {}"+ customerId));
    }
}
