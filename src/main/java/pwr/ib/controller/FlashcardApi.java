package pwr.ib.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.Flashcard;
import pwr.ib.service.SetOfFlashcards;
import pwr.ib.service.manager.FlashcardManager;

import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin
public class FlashcardApi {

    private FlashcardManager flashcards;

    @Autowired
    public FlashcardApi(FlashcardManager flashcards) {
        this.flashcards = flashcards;
    }

    @GetMapping("api/flashcard/all")
    public Iterable<Flashcard> getAllFlashcards() {
        return flashcards.findAll();
    }

    @GetMapping("api/flashcard")
    public Optional<Flashcard> getById(@RequestParam Long index) {
        return flashcards.findById(index);
    }

}
