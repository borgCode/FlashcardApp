package com.borgcode.flashcardapp.service;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.entity.Deck;

import java.time.LocalDateTime;
import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    List<Card> getCardsByDeckId(Long id);
    Card getDueCard(LocalDateTime localDateTime, Deck deck);
    Card getCardById(Long id);

    Card saveCard(Card card);

    Card updateCard(Card card);

    void deleteCard(Long id);
}
