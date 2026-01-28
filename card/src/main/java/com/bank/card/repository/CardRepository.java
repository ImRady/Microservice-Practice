package com.bank.card.repository;

import com.bank.card.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {


    List<Card> findByCustomerId(String customerId);
}
