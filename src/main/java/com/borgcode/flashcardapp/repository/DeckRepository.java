package com.borgcode.flashcardapp.repository;

import com.borgcode.flashcardapp.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
}
