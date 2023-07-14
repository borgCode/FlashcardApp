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

import java.time.LocalDateTime;

@Controller
public class CardController {

    private CardService cardService;
    private DeckService deckService;

    public CardController(CardService cardService, DeckService deckService) {
        this.cardService = cardService;
        this.deckService = deckService;
    }
    @GetMapping("/study/{id}/new")
    public String createCardForm(@PathVariable Long id, Model model) {
        Card card = new Card();
        model.addAttribute("card", card);
        model.addAttribute("deckId", id);
        return "create_card";
    }


    @GetMapping("/study/edit/{deckId}/{cardId}")
    public String editCard(@PathVariable Long deckId, @PathVariable Long cardId, Model model) {
        model.addAttribute("currentCard", cardService.getCardById(cardId));
        Card card = new Card();
        model.addAttribute("updatedCard", card);
        model.addAttribute("deck", deckService.getDeckById(deckId));
        return "edit_card";

    }
    @PostMapping("/study/{deckId}/{cardId}")
    public String updateCard(@PathVariable Long deckId, @PathVariable Long cardId,
                             @ModelAttribute("updatedCard")Card card,
                             Model model) {
        Card existingCard = cardService.getCardById(cardId);
        existingCard.setCardId(cardId);
        existingCard.setFrontSide(card.getFrontSide());
        existingCard.setBackSide(card.getBackSide());
        existingCard.setLocalDateTime(cardService.getCardById(cardId).getLocalDateTime());
        cardService.updateCard(existingCard);

        return "redirect:/study/" + deckService.getDeckById(deckId).getId();


    }

    @GetMapping("/study/delete/{deckId}/{cardId}")
    public String deleteCard(@PathVariable Long deckId, @PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return "redirect:/study/" + deckService.getDeckById(deckId).getId();
    }
    @GetMapping("/wrong/{deckId}/{cardId}")
    public String setWrongCardDueDate(@PathVariable Long deckId, @PathVariable Long cardId) {
        Card card = cardService.getCardById(cardId);
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(30);
        card.setLocalDateTime(localDateTime);
        cardService.updateCard(card);
        return "redirect:/study/" + deckService.getDeckById(deckId).getId();
    }

    @GetMapping("/correct/{deckId}/{cardId}")
    public String setCorrectCardDueDate(@PathVariable Long deckId, @PathVariable Long cardId) {
        Card card = cardService.getCardById(cardId);
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
        card.setLocalDateTime(localDateTime);
        cardService.updateCard(card);
        return "redirect:/study/" + deckService.getDeckById(deckId).getId();
    }


    @PostMapping("/study/{id}")
    public String saveCard(@PathVariable Long id, @ModelAttribute("card") Card card) {
        card.setDeck(deckService.getDeckById(id));
        card.setLocalDateTime(LocalDateTime.now());
        cardService.saveCard(card);
        return "redirect:/study/" + deckService.getDeckById(id).getId();
    }

}
