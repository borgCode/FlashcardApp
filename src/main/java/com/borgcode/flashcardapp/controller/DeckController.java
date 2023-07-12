package com.borgcode.flashcardapp.controller;

import com.borgcode.flashcardapp.entity.Card;
import com.borgcode.flashcardapp.entity.Deck;
import com.borgcode.flashcardapp.service.CardService;
import com.borgcode.flashcardapp.service.DeckService;
import com.borgcode.flashcardapp.service.impl.CardServiceImpl;
import com.borgcode.flashcardapp.service.impl.DeckServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeckController {

    private DeckService deckService;
    private CardService cardService;

    public DeckController(DeckServiceImpl deckServiceImpl, CardServiceImpl cardServiceImpl) {
        this.deckService = deckServiceImpl;
        this.cardService = cardServiceImpl;
    }

    @GetMapping("/decks")
    public String listDecks(Model model) {
        model.addAttribute("decks", deckService.getAllDecks());
        return "decks";
    }

    @GetMapping("/decks/{id}")
    public String deleteDeck(@PathVariable Long id) {
        deckService.deleteDeckById(id);
        return "redirect:/decks";
    }

    @GetMapping("/decks/new")
    public String createDeckForm(Model model) {
        Deck deck = new Deck();
        model.addAttribute("deck", deck);
        return "create_deck";

    }

    @PostMapping("/decks")
    public String saveDeck(@ModelAttribute("deck") Deck deck) {
        deckService.saveDeck(deck);
        return "redirect:/decks";
    }


    @GetMapping("/study/{id}")
    public String getCardsByDeckId(@PathVariable Long id, Model model) {
        model.addAttribute("deck", deckService.getDeckName(id));
        model.addAttribute("deckId", id);
        return "study";

    }

    @GetMapping("/study/{id}/list")
    public String listDeckCards(@PathVariable Long id, Model model) {
        model.addAttribute("deck", deckService.getDeckName(id));
        model.addAttribute("cards", cardService.getCardsByDeckId(id));
        model.addAttribute("deckId", id);
        return "list_deck_cards";
    }


}
