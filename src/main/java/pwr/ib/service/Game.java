package pwr.ib.service;

import pwr.ib.jwt.models.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = Game.TABLE_NAME)
public class Game implements Comparable{

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
    private User userDto;

    public Game(String gameMode, SetOfFlashcards setOfFlashcards, User userDto) {
        this.date = LocalDateTime.now();
        this.points =0;
        this.gameMode = gameMode;
        this.setOfFlashcards = setOfFlashcards;
        this.userDto=userDto;
        this.ranking = false;
    }

    public Game(String gameMode, int points, SetOfFlashcards setOfFlashcards, User userDto, Boolean ranking) {
        this.date = LocalDateTime.now();
        this.points =points;
        this.gameMode = gameMode;
        this.ranking = ranking;
        this.setOfFlashcards = setOfFlashcards;
        this.userDto=userDto;
    }

    public Game(Long id, LocalDateTime date, int points, String gameMode, boolean ranking, SetOfFlashcards setOfFlashcards, User userDto) {
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

    public User getUserDto() {
        return userDto;
    }

    public void setUserDto(User userDto) {
        this.userDto = userDto;
    }

    @Override
    public int compareTo(Object o) {
        Game game2 = (Game) o;
        return -(Integer.compare(this.getPoints(), game2.getPoints()));
    }
}
