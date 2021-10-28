package nix.education.java.hangman;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    private int answerIndex = (int) (Math.random() * 4);
    private String userWord;

    public void setWord() {
        System.out.println("Guess the word: > ");
        userWord = scanner.nextLine();
    }

    public void getDestiny() {
        if (userWord.equals(answers[answerIndex])) { System.out.println("You survived!"); }
        else {System.out.println("You lost!"); }
    }
}
