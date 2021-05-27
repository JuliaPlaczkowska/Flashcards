package pwr.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.ib.service.Flashcard;

@Repository
public interface FlashcardRepo extends CrudRepository<Flashcard, Long> {
}
