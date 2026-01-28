package com.bank.card.service.cardService;


import com.bank.card.domain.entity.Card;
import com.bank.card.dto.Card.CardRequest;
import com.bank.card.mapper.CardMapper;
import com.bank.card.repository.CardRepository;
import com.bank.card.service.feignClient.feignClient.CustomerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {


    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    private final CustomerFeignClient customerFeignClient;


    @Override
    public Card createCard(CardRequest card) {
        Boolean exists = customerFeignClient.existsById(card.getCustomerId());

        if (Boolean.FALSE.equals(exists)) {
            throw new RuntimeException("Customer  not found");
        }
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

    @Override
    public List<Card> getCardsByCustomerId(String customerId) {
        return cardRepository.findByCustomerId(customerId);
    }
}
