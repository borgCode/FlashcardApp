package com.borgcode.flashcardapp.repository;

import com.borgcode.flashcardapp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByDeckId(long id);
}
