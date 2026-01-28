package com.bank.account.service.client;


import com.bank.account.dto.loan.LoanResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "loan")
public interface LoanFeignClient {

    @GetMapping("api/loans/{customerId}/customer")
    List<LoanResponse> getLoansByCustomerId(@PathVariable String customerId);
}
