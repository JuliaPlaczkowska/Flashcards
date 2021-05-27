package pwr.ib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.ib.service.Game;

@Repository
public interface GameRepo extends CrudRepository<Game, Long> {
}
