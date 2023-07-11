package com.borgcode.flashcardapp.controller;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.service.CardService;
import com.borgcode.flashcardapp.service.DeckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CardController {

    private CardService cardService;
    private DeckService deckService;

    public CardController(CardService cardService, DeckService deckService) {
        this.cardService = cardService;
        this.deckService = deckService;
    }
    @GetMapping("/study/{id}/new")
    public String createCardForm(Model model) {
        Card card = new Card();
        model.addAttribute("card", card);
        return "create_card";
    }

    @PostMapping("/study/{id}/new")
    public String saveCard(@PathVariable Long id, @ModelAttribute("card") Card card) {
        card.setDeck(deckService.getDeckById(id));
        cardService.saveCard(card);
        return "redirect:study/{id}";
    }
}
