package at.spengergasse.entities;

import javax.persistence.*;
import java.util.List;

public class AnswerSelection {

    private int id;
    private String[] answers;
    Question q = new Question();
    EntityManager em = Persistence.createEntityManagerFactory("demo")
            .createEntityManager();
    TypedQuery<Question> query = em.createQuery("SELECT q from Question q", Question.class);
    List<Question> questions = query.getResultList();


    public void setId() {
        for (int i = 1; i <= questions.size(); i++){
            this.id = i; //letzte Zahl kommt raus -> falsch
            //für jede Id soll eine Zahl gegeben werden 1 bis 5
            //darf keine Duplikate enthalten
        }
    }

    public int getId() {
        return id;
    }

    public String[] getAnswers() {
        return answers;
    }
}
