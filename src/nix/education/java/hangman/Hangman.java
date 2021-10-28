package nix.education.java.hangman;
import java.util.Scanner;

final class Hangman {

    final Scanner scanner = new Scanner(System.in);

    final String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    // Опрееляем ответ. Делим ответ на отеьные буквы.
    final int answerIndex = (int) (Math.random() * 4);
    final char[] answer = splitWordIntoLetters(answers[answerIndex]);
    // Глобальные переменные
    private char userLetter;
    private int guessedLetters = 0;
    final int length = answers[answerIndex].length();
    private int attemptLeft = 7;
    // Формируемый ответ
    private char[] userWord = maskingTheWord(answers[answerIndex], guessedLetters);

    // Ввод буквы пользователем
    public void setLetter() {
        getDestiny();
        System.out.println(userWord);
        System.out.println("Input a letter: > ");
        userLetter = scanner.next().charAt(0);
    }

    // Определение "судьбы" игрока в зависимости от количества попыток
    //
    private void getDestiny() {
        if (guessedLetters == length && attemptLeft > 1) {
            System.out.println("You guessed the word!\n" +
                    "You survived!");
            System.exit(0);
        }
        else if (attemptLeft == 0) {
            System.out.println("Thanks for playing!\nWe'll see how well you did in the next stage");
            System.exit(0);
        }
    }

    // Выполнение действий в зависимости от того, что вернула checkLetter
    public void makeDecisions() {
        int actinCode = checkLetter();
        getMistakeMessage(actinCode);
        if (actinCode == 0 || actinCode == 1) {
            attemptLeft--;
        }
    }

    // Разделение String на char
    private char[] splitWordIntoLetters(String word) {
        char[] letters = word.toCharArray();
        return letters;
    }

    // Замена n символов в слове на -
    private char[] maskingTheWord(String word, int n) {
        char[] maskedWord = splitWordIntoLetters(word);

        for (int i = n; i < word.length(); i++) {
            maskedWord[i] = '-';
        }
        return maskedWord;
    }

    /*
    Проверяет, имеется ли введенная пользователем буква в слове
    0 - нет буквы; 1 - буква есть, но игрок её уже нашел; 2 - игрок угадал букву*/
    private int checkLetter() {
        int returnCode = 0;
        for (int i = 0; i < length; i++) {
            if (userLetter == answer[i]) {
                if (userLetter != userWord[i]) { // Отсекает вариант, когда пользователь пытается ввести уже введенную букву
                    userWord[i] = userLetter;
                    returnCode = 2;
                    guessedLetters++; // Количество угаданных букв
                } else { returnCode = 1; }
            }
        }
        return returnCode;
    }

    // В зависимости введенного кода выдает соответствующее сообщение
    private void getMistakeMessage(int actionCode) {
        if (actionCode == 0) {System.out.println("That letter doesn't appear in the word");}
        else if (actionCode == 1) {System.out.println("No improvements");}
    }
}
