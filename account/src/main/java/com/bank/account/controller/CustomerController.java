package com.bank.account.controller;



import com.bank.account.domain.model.Customer;
import com.bank.account.dto.card.CardResponse;
import com.bank.account.dto.customer.CustomerReponseDetail;
import com.bank.account.dto.customer.CustomerRequest;

import com.bank.account.dto.customer.CustomerResponse;
import com.bank.account.dto.loan.LoanResponse;
import com.bank.account.mapping.CustomerMapper;
import com.bank.account.service.client.CardFeignClient;
import com.bank.account.service.client.LoanFeignClient;
import com.bank.account.service.customer.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    private final CardFeignClient cardFeignClient;

    private final LoanFeignClient loanFeignClient;


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

    @GetMapping("/customerDetail/{customerId}")
    @CircuitBreaker(name = "detailsForCustomerSupportApp")
    public ResponseEntity<CustomerReponseDetail>getCustomerDetail(@PathVariable String customerId){

        CustomerReponseDetail customerReponseDetail = new CustomerReponseDetail();

        Customer customer = customerService.getByCustomerId(customerId);

        if(customer == null){

            throw new RuntimeException("Customer not found");
        }

        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
        List<LoanResponse> loansByCustomerId = loanFeignClient.getLoansByCustomerId(customerId);
        List<CardResponse> cardInfo = cardFeignClient.getCardInfo(customerId);

        customerReponseDetail.setCustomer(customerResponse);
        customerReponseDetail.setCards(cardInfo);
        customerReponseDetail.setLoans(loansByCustomerId);
        return ResponseEntity.ok(customerReponseDetail);
    }

    @GetMapping("{customerId}/exists")
    public ResponseEntity<Boolean> existsById(@PathVariable String customerId){
        boolean exists = customerService.existsById(customerId);
        return ResponseEntity.ok(exists);
    }



}
