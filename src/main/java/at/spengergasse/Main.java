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


        //Questions hat schon die Antworten
        // daher muss man sie nicht extra mit set Methode speichern
        Scanner scanner = new Scanner(System.in);

        TypedQuery<Question> queryQue = em.createQuery("SELECT q from Question q", Question.class);
        List<Question> questions = queryQue.getResultList();

        char[] answerChar = new char[4];
        answerChar = new char[]{'a', 'b', 'c', 'd'};

        System.out.println("___________Quiz___________");

        BenutzerAntworten benutzer = new BenutzerAntworten();
        String eingabe = benutzer.getAntwort();
        String selection = "Selection: ";
        String correct = "Correct: ";



        for (Question q : questions) {

            String richtigeAntwort = " ";
            List<Answer> answers = q.getAnswers();
            System.out.println(q.getText());
            System.out.println(selection);
            for (int i = 0; i < q.getAnswers().size(); i++) {
                System.out.println(answerChar[i] + ") " + answers.get(i).getText());
                if (answers.get(i).isCorrect()) {
                    richtigeAntwort = String.valueOf(answerChar[i]);
                    correct += richtigeAntwort + ") " + answers.get(i).getText();
                }
                //isCorrect = false oder true für jede Antwort
            }

            boolean korrekteEingabe = false;
            while (!korrekteEingabe) {
                System.out.print("Your Answer: ");
                eingabe = (scanner.next());
                if (!eingabe.matches("[a-d]")) {
                    System.out.println("Bitte nur a - d eingeben!");
                }
                else
                {
                    korrekteEingabe = true;
                }
            }
            if (!eingabe.equals(richtigeAntwort)) {
                System.out.println(correct);
                System.out.println("\n--next Question--");
            }
            else
            {
                System.out.println("\n--next Question--");
            }
            correct = "Correct: ";

        }
        em.close();
    }
}
