package com.borgcode.flashcardapp.controller;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/study/{id}/new")
    public String saveCard(@PathVariable Long id, @ModelAttribute("card") Card card) {
        cardService.saveCard(card);
        return "redirect:study/{id}";
    }
}
