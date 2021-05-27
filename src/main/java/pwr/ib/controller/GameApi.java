package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.Game;
import pwr.ib.service.GameManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping
public class GameApi {
    private GameManager games;

    @Autowired
    public GameApi(GameManager gameManager){
        this.games = gameManager;
    }

    @GetMapping("api/game/all")
    public Iterable<Game> getAllGames() {
        return games.findAll();
    }

    @GetMapping("api/game")
    public Optional<Game> getGameById(@RequestParam Long index) {
        return games.findById(index);
    }

    @GetMapping("api/game/user")
    public Iterable<Game> getGameByUserId(@RequestParam Long index) {

        Iterable<Game> games =  this.games.findAll();
        ArrayList<Game> out = new ArrayList<>();

        for(Game g:games)
            if(g.getUserDto().getId()==index)
                out.add(g);

        return out;
    }

    @PostMapping("api/game")
    public Game addGame(@RequestBody Game game ){
        return  games.save(game);
    }

    @PutMapping("api/admin/game")
    public Game updateGame(@RequestBody Game game ){
        return  games.save(game);
    }

}
