package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.BenutzerAntworten;
import at.spengergasse.entities.Question;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        Question q1 = em.find(Question.class, 1);

        Scanner scanner = new Scanner(System.in);

        TypedQuery<Question> queryQue = em.createQuery("SELECT q from Question q", Question.class);
        List<Question> questions = queryQue.getResultList();

        Question answers = new Question();
        answers.setAnswers(answers.getAnswers());

        System.out.println("___________Fragen beantworten___________");

        BenutzerAntworten benutzer = new BenutzerAntworten();
        String selection = "Selection: ";
        String correct = "Correct: ";
//
        for (int i = 0; i < questions.size(); i++) {

            System.out.println(questions.get(0).getText());
            System.out.println(selection);


        }

        em.close();
    }
}
