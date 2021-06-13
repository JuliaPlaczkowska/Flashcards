package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.*;
import pwr.ib.service.manager.FlashcardManager;
import pwr.ib.service.manager.SetOfFlashcardsManager;

import java.util.Optional;

@RestController
@RequestMapping
public class SetOfFlashcardsApi {

    private SetOfFlashcardsManager sets;
    private FlashcardManager flashcards;

    @Autowired
    public SetOfFlashcardsApi(SetOfFlashcardsManager sets,
                              FlashcardManager flashcards)
    {this.sets = sets;
    this.flashcards = flashcards;}

    @GetMapping("api/set/all")
    public Iterable<SetOfFlashcards> getAllSets(){return sets.findAll();}

    @GetMapping("api/set")
    public Optional<SetOfFlashcards> getSetById(@RequestParam Long index) {
        return sets.findById(index);
    }

    @PostMapping("api/admin/set")
    public SetOfFlashcards addUser(@RequestBody SetOfFlashcards setOfFlashcards ){
        for (Flashcard flashcard: setOfFlashcards.getFlashcards()) {
            flashcards.save(flashcard);
        }
        return  sets.save(setOfFlashcards);
    }
}
