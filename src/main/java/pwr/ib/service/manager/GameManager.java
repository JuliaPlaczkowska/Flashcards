package pwr.ib.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.ib.repository.GameRepo;
import pwr.ib.service.Game;

import java.util.Optional;

@Service
public class GameManager {

    private GameRepo gameRepo;

    @Autowired
    public GameManager(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Optional<Game> findById(Long id){
        return gameRepo.findById(id);
    }

    public Iterable<Game> findAll(){
        return gameRepo.findAll();
    }

    public Game save(Game game){
        return gameRepo.save(game);
    }

    public void delete(Game game) { gameRepo.delete(game);}
}
