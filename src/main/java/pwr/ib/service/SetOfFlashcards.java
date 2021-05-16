package pwr.ib.service;

import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = SetOfFlashcards.TABLE_NAME)
public class SetOfFlashcards {

    public static final String TABLE_NAME="setofflashcards";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String name;

    @OneToMany
    private Set<Flashcard> flashcards = new HashSet<>();

    public SetOfFlashcards( String category, String name, Set<Flashcard> flashcards) {
        this.category = category;
        this.name = name;
        this.flashcards = flashcards;
    }

    public SetOfFlashcards() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Set<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }
}
