package com.borgcode.flashcardapp.service.impl;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.entity.Deck;
import com.borgcode.flashcardapp.repository.CardRepository;
import com.borgcode.flashcardapp.service.CardService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public Card getDueCard(LocalDateTime localDateTime, Deck deck) {
        return cardRepository.findFirstByLocalDateTimeBeforeAndDeck(localDateTime, deck);
    }

    @Override
    public Card getCardById(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
