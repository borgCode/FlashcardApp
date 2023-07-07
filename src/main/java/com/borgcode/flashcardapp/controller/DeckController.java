package com.borgcode.flashcardapp.controller;

import com.borgcode.flashcardapp.service.DeckService;
import com.borgcode.flashcardapp.service.impl.DeckServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeckController {

    private DeckService deckService;

    public DeckController(DeckServiceImpl deckServiceImpl) {
        this.deckService = deckServiceImpl;
    }

    @GetMapping("/decks")
    public String listDecks(Model model) {
        model.addAttribute("decks", deckService.getAllDecks());
        return "decks";
    }


}
