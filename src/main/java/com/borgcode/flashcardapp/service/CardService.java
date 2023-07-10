package com.borgcode.flashcardapp.service;

import com.borgcode.flashcardapp.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getAllCards();
    List<Card> getCardsByDeckId(Long id);

    Card saveCard(Card card);
}
