package nix.education.java.hangman;
import java.util.Scanner;

public class Hangman {

    private Scanner scanner = new Scanner(System.in);

    private String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    // Опрееляем ответ. Делим ответ на отеьные буквы.
    private int answerIndex = (int) (Math.random() * 4);
    private char[] answer = splitWordIntoLetters(answers[answerIndex]);
    // Глобальные переменные
    private char userLetter;
    private int guessedLetters = 0;
    private int length = answers[answerIndex].length();
    private int attemptLeft = 7;
    // Формируемый ответ
    private char[] userWord = maskingTheWord(answers[answerIndex], guessedLetters);

    public void setLetter() {
        System.out.println(userWord);
        System.out.println("Input a letter: > ");
        userLetter = scanner.next().charAt(0);
    }

    private void getDestiny() {
        if (guessedLetters == length + 100) {
            System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
            System.exit(0);
        }
        else if (attemptLeft == 0 ) {
            System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
            System.exit(0);
        }
    }

    public void makeDecisions() {
        getDestiny();
        if (checkLetter() == false) {
            attemptLeft--;
            System.out.println("That letter doesn't appear in the word");
        } else {attemptLeft--;}
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

    private boolean checkLetter() {
        boolean hasLetter = false;
        for (int i = 0; i < length; i++) {
            if (userLetter == answer[i]) {
                if (userLetter != userWord[i]) {
                    userWord[i] = userLetter;
                    hasLetter = true;
                    guessedLetters++;
                }
            }
        }
        return hasLetter;
    }
}
