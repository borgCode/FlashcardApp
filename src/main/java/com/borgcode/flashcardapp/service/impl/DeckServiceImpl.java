package com.borgcode.flashcardapp.service.impl;

import com.borgcode.flashcardapp.entity.Deck;
import com.borgcode.flashcardapp.repository.DeckRepository;
import com.borgcode.flashcardapp.service.DeckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {
    private DeckRepository deckRepository;

    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @Override
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    @Override
    public String getDeckName(long id) {
        return deckRepository.findById(id).get().getDeckName();
    }

    @Override
    public Deck saveDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public Deck getDeckById(Long id) {
        return deckRepository.findById(id).get();
    }

    @Override
    public void deleteDeckById(Long id) {
        deckRepository.deleteById(id);
    }


}
