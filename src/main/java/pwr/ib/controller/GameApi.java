package pwr.ib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;
import pwr.ib.service.Game;
import pwr.ib.service.SetOfFlashcards;
import pwr.ib.service.UserDto;
import pwr.ib.service.manager.GameManager;
import pwr.ib.service.manager.UserManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping
public class GameApi {
    private GameManager games;
    private UserManager users;

    @Autowired
    public GameApi(GameManager gameManager, UserManager users){
        this.games = gameManager;
        this.users = users;
    }

    @GetMapping("api/game/all")
    public Iterable<Game> getAllGames() {
        return games.findAll();
    }

    @GetMapping("api/game")
    public Optional<Game> getGameById(@RequestParam Long index) {
        return games.findById(index);
    }

    @GetMapping("api/game/user/current")
    public Iterable<Game> getGamesForCurrentUser(@CurrentSecurityContext(expression="authentication?.name")
                                                         String username) {
        UserDto user = users.loadUserDtoByUsername(username);
        Iterable<Game> games =  this.games.findAll();
        ArrayList<Game> out = new ArrayList<>();

        for(Game g:games)
            if(g.getUserDto().getId().equals(user.getId()))
                out.add(g);

        return out;
    }

    @GetMapping("api/game/set")
    public Iterable<Game> getGamesBySetId(Long index) {

        Iterable<Game> games =  this.games.findAll();
        ArrayList<Game> out = new ArrayList<>();

        for(Game g : games){
            if(g.getSetOfFlashcards().getId()==index)
                out.add(g);
        }

        Collections.sort(out);

        return out;
    }

    @GetMapping("api/game/user")
    public Iterable<Game> getGamesByUserId(@RequestParam Long index) {

        Iterable<Game> games =  this.games.findAll();
        ArrayList<Game> out = new ArrayList<>();

        for(Game g:games)
            if(g.getUserDto().getId()==index)
                out.add(g);

        return out;
    }

    @DeleteMapping("api/admin/game")
    public void deleteGame(@RequestBody Game game){games.delete(game);}

    @PostMapping("api/game")
    public Game addGame(@RequestBody Game game ){
        return  games.save(game);
    }

}
