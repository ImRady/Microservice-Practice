package com.bank.account.controller;



import com.bank.account.domain.model.Customer;
import com.bank.account.dto.CustomerRequest;

import com.bank.account.dto.CustomerResponse;
import com.bank.account.mapping.CustomerMapper;
import com.bank.account.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "api/customers")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    private final CustomerMapper customerMapper;


    @PostMapping
    public ResponseEntity<?>saveCustomer(@RequestBody CustomerRequest request){


        Customer save = customerService.save(request);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(save);

        return ResponseEntity.ok(customerResponse);

    }

    @GetMapping
    public ResponseEntity<?> getCustomer(){
        List<Customer> customers = customerService.getCustomers();

        List<CustomerResponse> customerResponses =
                customerMapper.toCustomerResponses(customers);

        return ResponseEntity.ok(customerResponses);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable("customerId") String customerId){
        Customer customerById = customerService.getByCustomerId(customerId);
        customerMapper.toCustomerResponse(customerById);
        return ResponseEntity.ok(customerById);
    }


}
