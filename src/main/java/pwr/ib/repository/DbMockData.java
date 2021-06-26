package pwr.ib.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import pwr.ib.jwt.models.ERole;
import pwr.ib.jwt.models.Role;
import pwr.ib.jwt.models.User;
import pwr.ib.jwt.repository.RoleRepository;
import pwr.ib.jwt.repository.UserRepository;
import pwr.ib.service.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbMockData {


    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private FlashcardRepo flashcardRepo;
    private SetOfFlashcardsRepo setOfFlashcardsRepo;
    private GameRepo gameRepo;

    @Autowired
    public DbMockData(RoleRepository roleRepository, UserRepository userRepository, FlashcardRepo flashcardRepo, SetOfFlashcardsRepo setOfFlashcardsRepo, GameRepo gameRepo) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.flashcardRepo = flashcardRepo;
        this.setOfFlashcardsRepo = setOfFlashcardsRepo;
        this.gameRepo = gameRepo;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void fill(){

        Role roleAdmin = new Role(ERole.ROLE_ADMIN);
        Role roleUser = new Role(ERole.ROLE_USER);

        Set<Role> userRoles = new HashSet<>(Arrays.asList(roleUser));
        Set<Role> adminRoles = new HashSet<>(Arrays.asList(roleAdmin));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User("ania", "ania@ania.pl", passwordEncoder.encode("123321"));
        user.setRoles(userRoles);
        User admin = new User("admin", "io.flashcardsapp@admin.pl", passwordEncoder.encode("123321"));
        admin.setRoles(adminRoles);
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

       roleRepository.save(roleAdmin);
       roleRepository.save(roleUser);
        userRepository.save(user);
        userRepository.save(admin);
        flashcardRepo.save(flashcard1);
        flashcardRepo.save(flashcard2);
        flashcardRepo.save(flashcard3);
        flashcardRepo.save(flashcard4);
        setOfFlashcardsRepo.save(setOfFlashcards);
       // gameRepo.save(game);

    }

}
