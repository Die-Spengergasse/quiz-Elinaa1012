package at.spengergasse;

import at.spengergasse.entities.AnswerSelection;
import at.spengergasse.entities.BenutzerAntworten;
import at.spengergasse.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        Scanner scanner = new Scanner(System.in);

        TypedQuery<Question> query = em.createQuery("SELECT q from Question q", Question.class);
        List<Question> questions = query.getResultList();

        System.out.println("___________Fragen beantworten___________");

        BenutzerAntworten benutzer = new BenutzerAntworten();

        for (int i = 0; i < questions.size(); i++) {


        }

        AnswerSelection a = new AnswerSelection();
        a.setId();
        AnswerSelection b = new AnswerSelection();
        b.setId();
        System.out.println(a.getId() + " " + b.getId());

        em.close();
    }
}
