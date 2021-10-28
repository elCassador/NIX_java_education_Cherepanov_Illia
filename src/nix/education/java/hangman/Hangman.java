package nix.education.java.hangman;
import java.util.Scanner;

public class Hangman {

    private String[] answers = new String[] {"java"};
    private int answerIndex = 0;
    private String userWord;
    private Scanner scanner = new Scanner(System.in);

    public void setWord() {
        System.out.println("Guess the word: > ");
        userWord = scanner.nextLine();
    }

    public void getDestiny() {
        if (userWord.equals(answers[answerIndex])) { System.out.println("You survived!"); }
        else {System.out.println("You lost!"); }
    }
}
