package at.spengergasse.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="q_questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "q_id")
    private int id;
    @Column (name="q_text")
    private String text;

    @OneToMany //eine 1 zu n Beziehung
    @JoinColumn(name = "fk_q_id") //verbinde mit Answer-Tabelle
    private List<Answer> answerList = new ArrayList<>();


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }
}
