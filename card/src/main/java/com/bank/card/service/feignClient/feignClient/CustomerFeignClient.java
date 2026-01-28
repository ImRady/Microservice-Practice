package com.bank.card.service.feignClient.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account")
public interface CustomerFeignClient {

        @GetMapping("/api/customers/{customerId}/exists")
        Boolean existsById(@PathVariable String customerId);
}
