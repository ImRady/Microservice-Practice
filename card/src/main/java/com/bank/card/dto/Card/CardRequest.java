package com.bank.card.dto.Card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CardRequest {


    @NotNull
    private String customerId;

    @NotBlank
    private String cardType;

    @Positive
    private BigDecimal totalLimit;

    @Positive
    private BigDecimal amountUsed;

    @Positive
    private BigDecimal availableAmount;
    
    @NotNull
    private LocalDate createdDate;
}
