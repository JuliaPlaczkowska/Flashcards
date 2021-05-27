package pwr.ib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.ib.repository.FlashcardRepo;

import java.util.Optional;

@Service
public class FlashcardManager {

    private FlashcardRepo flashcardRepo;

    @Autowired
    public FlashcardManager(FlashcardRepo flashcardRepo) {
        this.flashcardRepo = flashcardRepo;
    }

    public Optional<Flashcard> findById(Long id){
        return flashcardRepo.findById(id);
    }

    public Iterable<Flashcard> findAll(){
        return flashcardRepo.findAll();
    }

    public Flashcard save(Flashcard flashcard){
        return flashcardRepo.save(flashcard);
    }
}
