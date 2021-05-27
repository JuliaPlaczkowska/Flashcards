package pwr.ib.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.Flashcard;
import pwr.ib.service.FlashcardManager;
import pwr.ib.service.Game;

@RestController
@RequestMapping
public class FlashcardApi {

    private FlashcardManager flashcards;

    @Autowired
    public FlashcardApi(FlashcardManager flashcards) {
        this.flashcards = flashcards;
    }

    @GetMapping("api/flashcard/all")
    public Iterable<Flashcard> getAllGames() {
        return flashcards.findAll();
    }

    @PostMapping("api/flashcard")
    public Flashcard addFlashcard(@RequestBody Flashcard flashcard ){
        return  flashcards.save(flashcard);
    }
}
