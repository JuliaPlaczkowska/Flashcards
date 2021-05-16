package pwr.ib.service;

import javax.persistence.*;

@Entity
@Table(name = Flashcard.TABLE_NAME)
public class Flashcard {

    public static final String TABLE_NAME="flashcard";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;

    public Flashcard( String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Flashcard() {
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
