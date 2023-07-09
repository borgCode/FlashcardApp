package com.borgcode.flashcardapp.service.impl;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.repository.CardRepository;
import com.borgcode.flashcardapp.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> getCardsByDeckId(Long id) {
        return cardRepository.findAllByDeckId(id);
    }
}
