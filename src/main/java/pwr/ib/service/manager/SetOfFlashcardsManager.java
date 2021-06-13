package pwr.ib.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.ib.repository.SetOfFlashcardsRepo;
import pwr.ib.service.SetOfFlashcards;

import java.util.Optional;

@Service
public class SetOfFlashcardsManager {

    private SetOfFlashcardsRepo setOfFlashcardsRepo;

    @Autowired
    public SetOfFlashcardsManager(SetOfFlashcardsRepo setOfFlashcardsRepo){
        this.setOfFlashcardsRepo = setOfFlashcardsRepo;
    }

    public Optional<SetOfFlashcards> findById(Long id){
        return setOfFlashcardsRepo.findById(id);
    }

    public Iterable<SetOfFlashcards> findAll(){
        return setOfFlashcardsRepo.findAll();
    }

    public SetOfFlashcards save(SetOfFlashcards setOfFlashcards){
        return setOfFlashcardsRepo.save(setOfFlashcards);
    }

    public void delete(SetOfFlashcards setOfFlashcards){
        setOfFlashcardsRepo.delete(setOfFlashcards);
    }

    public void deleteById(Long id){
        setOfFlashcardsRepo.deleteById(id);
    }

    public Long countAll(){
        return setOfFlashcardsRepo.count();
    }

}
