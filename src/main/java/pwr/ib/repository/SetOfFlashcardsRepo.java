package pwr.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.ib.service.SetOfFlashcards;

@Repository
public interface SetOfFlashcardsRepo extends CrudRepository<SetOfFlashcards, Long> {
}
