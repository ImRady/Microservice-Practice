package com.bank.card.service.cardService;


import com.bank.card.domain.entity.Card;
import com.bank.card.dto.Card.CardRequest;
import com.bank.card.mapper.CardMapper;
import com.bank.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {


    private final CardMapper cardMapper;
    private final CardRepository cardRepository;


    @Override
    public Card createCard(CardRequest card) {
        Card cardEntity = cardMapper.toCard(card);
        return cardRepository.save(cardEntity);
    }

    @Override
    public Card getCardById(Long cardId) {

        return cardRepository.findById(cardId).orElseThrow(() ->
                new RuntimeException("Card not found"));
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
