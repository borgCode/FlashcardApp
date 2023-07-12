package com.borgcode.flashcardapp.service;

import com.borgcode.flashcardapp.entity.Deck;

import java.util.List;

public interface DeckService {

    List<Deck> getAllDecks();
    String getDeckName(long id);
    Deck saveDeck(Deck deck);
    Deck getDeckById(Long id);

    void deleteDeckById(Long id);

}
