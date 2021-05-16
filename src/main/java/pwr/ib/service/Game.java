package pwr.ib.service;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = Game.TABLE_NAME)
public class Game {

    public static final String TABLE_NAME="game";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private int points;
    private String gameMode;
    private boolean ranking;

    @ManyToOne
    private SetOfFlashcards setOfFlashcards;

    @ManyToOne
    private UserDto userDto;

    public Game(String gameMode, SetOfFlashcards setOfFlashcards, UserDto userDto) {
        this.date = LocalDateTime.now();
        this.points =0;
        this.gameMode = gameMode;
        this.setOfFlashcards = setOfFlashcards;
        this.userDto=userDto;
        this.ranking = false;
    }

    public Game(Long id, LocalDateTime date, int points, String gameMode, boolean ranking, SetOfFlashcards setOfFlashcards, UserDto userDto) {
        this.id = id;
        this.date = date;
        this.points = points;
        this.gameMode = gameMode;
        this.ranking = ranking;
        this.setOfFlashcards = setOfFlashcards;
        this.userDto  = userDto;
    }

    public Game() {
    }

    public void play(){

        //TODO

        if(gameMode.equals("flashcards"))
            new GameplayFlashcards();
        else
            new GameplayMemory();
    }

    public int showResult(){
        return this.points;
    }

    public void saveResultToRanking(){
        ranking = true;
    }

    public void deleteResultFromRanking(){
        ranking = false;
    }

    public void chooseGameMode(String gameMode){
        this.gameMode = gameMode;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public SetOfFlashcards getSetOfFlashcards() {
        return setOfFlashcards;
    }

    public void setSetOfFlashcards(SetOfFlashcards setOfFlashcards) {
        this.setOfFlashcards = setOfFlashcards;
    }

    public boolean isRanking() {
        return ranking;
    }

    public void setRanking(boolean ranking) {
        this.ranking = ranking;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}