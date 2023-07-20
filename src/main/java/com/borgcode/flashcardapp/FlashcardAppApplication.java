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
public class FlashcardAppApplication{

    public static void main(String[] args) {
        SpringApplication.run(FlashcardAppApplication.class, args);

    }

}
