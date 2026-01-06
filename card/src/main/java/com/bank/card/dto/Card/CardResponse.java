package com.bank.card.dto.Card;



import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CardResponse {

    private String cardId;

    private String customerId;

    private String cardType;

    private BigDecimal totalLimit;

    private BigDecimal amountUsed;

    private BigDecimal availableAmount;

    private LocalDate createdDate;
}
