package com.bank.card.service.cardService;


import com.bank.card.domain.entity.Card;
import com.bank.card.dto.Card.CardRequest;

import java.util.List;

public interface CardService {

    Card createCard(CardRequest card);
    Card getCardById(Long cardId);
    List<Card> getAllCards();
    List<Card> getCardsByCustomerId(String customerId);


}
