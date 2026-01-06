package com.bank.card.controller;


import com.bank.card.domain.entity.Card;
import com.bank.card.dto.Card.CardRequest;
import com.bank.card.dto.Card.CardResponse;
import com.bank.card.mapper.CardMapper;
import com.bank.card.service.cardService.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping
    public ResponseEntity<?>getAllCards(){
        List<Card> allCards = cardService.getAllCards();
        List<CardResponse> cardResponse = cardMapper.toCardResponse(allCards);

        return ResponseEntity.ok(cardResponse);
    }

    @PostMapping
    public ResponseEntity<?>createCard(@RequestBody CardRequest cardRequest){
        Card createdCard = cardService.createCard(cardRequest);
        CardResponse cardResponse = cardMapper.toCardResponse(createdCard);

        return ResponseEntity.ok(cardResponse);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<?>getCardById(@PathVariable Long cardId){
        Card cardById = cardService.getCardById(cardId);
        CardResponse cardResponse = cardMapper.toCardResponse(cardById);

        return ResponseEntity.ok(cardResponse);
    }


}
