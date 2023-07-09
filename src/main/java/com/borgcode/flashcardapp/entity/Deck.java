package com.borgcode.flashcardapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="decks")
public class Deck {
    @Id
    @SequenceGenerator(
            name = "deck_sequence",
            sequenceName = "deck_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "deck_sequence"
    )
    private Long id;
    private String deckName;
    @OneToMany
    @JoinColumn(name="deck_id", referencedColumnName = "id")
    private List<Card> cards;

    public Deck() {
    }

    public Deck(String deckName) {
        this.deckName = deckName;
    }

    public Deck(String deckName, List<Card> cards) {
        this.deckName = deckName;
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long deckId) {
        this.id = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
