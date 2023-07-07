package com.borgcode.flashcardapp;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.entity.Deck;
import com.borgcode.flashcardapp.repository.CardRepository;
import com.borgcode.flashcardapp.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlashcardAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FlashcardAppApplication.class, args);

    }
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private DeckRepository deckRepository;

    @Override
    public void run(String... args) throws Exception {

        /*Card card1 = new Card("My name", "Your Name");
        Card card2 = new Card("ipsum", "lorem");
        Card card3 = new Card("hello", "yes");
        cardRepository.save(card1);
        cardRepository.save(card2);
        cardRepository.save(card3);

        Deck deck = new Deck("Test", List.of(card1, card2, card3));
        deckRepository.save(deck);

        deckRepository.save(new Deck("Test2"));*/



    }
}
