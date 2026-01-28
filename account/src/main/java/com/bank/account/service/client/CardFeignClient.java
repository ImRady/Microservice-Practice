package com.bank.account.service.client;


import com.bank.account.dto.card.CardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "card")
public interface CardFeignClient {

    @GetMapping("api/cards/{customerId}/customer")
    List<CardResponse> getCardInfo(@PathVariable String customerId);
}
