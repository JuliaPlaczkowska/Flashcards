package pwr.ib.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import pwr.ib.service.*;

import java.util.HashSet;
import java.util.Set;

@Component
public class DbMockData {


    private UserRepo userRepository;
    private FlashcardRepo flashcardRepo;
    private SetOfFlashcardsRepo setOfFlashcardsRepo;
    private GameRepo gameRepo;

    @Autowired
    public DbMockData(UserRepo userRepository, FlashcardRepo flashcardRepo,
                      SetOfFlashcardsRepo setOfFlashcardsRepo, GameRepo gameRepo) {
        this.userRepository = userRepository;
        this.flashcardRepo = flashcardRepo;
        this.setOfFlashcardsRepo = setOfFlashcardsRepo;
        this.gameRepo = gameRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){

        UserDto user = new UserDtoBuilder(new User("ania", "123", "ROLE_CUSTOMER")).getUserDto();
        UserDto admin = new UserDtoBuilder(new User("admin", "123", "ROLE_ADMIN")).getUserDto();
        Flashcard flashcard1 = new Flashcard("bourne-again shell", "bash");
        Flashcard flashcard2 = new Flashcard("send to background", "bg");
        Flashcard flashcard3 = new Flashcard("concatenate and print", "cat");
        Flashcard flashcard4 = new Flashcard("divide a file into several parts", "cut");

        Set<Flashcard> flashcards = new HashSet<>(){
            {
                add(flashcard1);
                add(flashcard2);
                add(flashcard3);
                add(flashcard4);
            }};

        SetOfFlashcards setOfFlashcards = new SetOfFlashcards("IT","linux commands", flashcards);

        Game game = new Game("flashcards", setOfFlashcards, user);

        userRepository.save(user);
        userRepository.save(admin);
        flashcardRepo.save(flashcard1);
        flashcardRepo.save(flashcard2);
        flashcardRepo.save(flashcard3);
        flashcardRepo.save(flashcard4);
        setOfFlashcardsRepo.save(setOfFlashcards);
        gameRepo.save(game);

    }

}
