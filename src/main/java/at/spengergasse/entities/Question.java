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

    @OneToMany(mappedBy= "question", cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_q_id")
    //CascadeType.ALL -> Wenn eine Frage gelöscht
    // wird werden die Antworten auch gelöscht
    private List<Answer> answers = new ArrayList<>();


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

    public List<Answer> getAnswers() {
        return answers;
    }

}
