package com.borgcode.flashcardapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @SequenceGenerator(
            name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "card_sequence"
    )
    private long cardId;

    private String frontSide;
    private String backSide;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deck_id")
    private Deck deck;


    public Card() {
    }

    public Card( String frontSide, String backSide) {
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(String frontSide) {
        this.frontSide = frontSide;
    }

    public String getBackSide() {
        return backSide;
    }

    public void setBackSide(String backSide) {
        this.backSide = backSide;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
