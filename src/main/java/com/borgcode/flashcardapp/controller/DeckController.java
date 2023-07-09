package com.borgcode.flashcardapp.controller;

import com.borgcode.flashcardapp.service.CardService;
import com.borgcode.flashcardapp.service.DeckService;
import com.borgcode.flashcardapp.service.impl.CardServiceImpl;
import com.borgcode.flashcardapp.service.impl.DeckServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/study/{id}")
    @ResponseBody
    public String getCardsByDeckId(@PathVariable Long id, Model model) {
        model.addAttribute("study", cardService.getCardsByDeckId(id));
        model.addAttribute(deckService.getDeckName(id));
        return "study";

    }


}
