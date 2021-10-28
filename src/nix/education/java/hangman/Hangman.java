package nix.education.java.hangman;
import java.util.Scanner;

public class Hangman {

    private Scanner scanner = new Scanner(System.in);

    private String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    private int answerIndex = (int) (Math.random() * 4);
    private String userWord;

    public void setWord() {
        System.out.print("Guess the word ");
        System.out.print(maskingTheWord(answers[answerIndex], 2));
        System.out.println(": > ");
        userWord = scanner.nextLine();
    }

    public void getDestiny() {
        if (userWord.equals(answers[answerIndex])) { System.out.println("You survived!"); }
        else {System.out.println("You lost!"); }
    }

    private char[] splitWordIntoLetters(String word) {
        char[] letters = word.toCharArray();
        return letters;
    }

    private char[] maskingTheWord(String word, int n) {
        char[] maskedWord = splitWordIntoLetters(word);

        for (int i = n; i < word.length(); i++) {
            maskedWord[i] = '-';
        }
        return maskedWord;
    }
}
