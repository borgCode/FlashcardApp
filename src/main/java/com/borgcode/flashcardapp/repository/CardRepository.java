package com.borgcode.flashcardapp.repository;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByDeckId(long id);
    Card findFirstByLocalDateTimeBeforeAndDeck(LocalDateTime localDateTime, Deck deck);

}
