package com.bank.card.mapper;


import com.bank.card.domain.entity.Card;
import com.bank.card.dto.Card.CardRequest;
import com.bank.card.dto.Card.CardResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {


    Card toCard(CardRequest cardRequest);
    CardRequest toCardRequest(Card card);
    List<CardResponse> toCardResponse(List<Card> cardList);
    CardResponse toCardResponse(Card card);


}
