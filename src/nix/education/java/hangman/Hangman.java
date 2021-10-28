package nix.education.java.hangman;
import java.util.Scanner;

final class Hangman {

    private final Scanner scanner = new Scanner(System.in);

    private final String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    // Опрееляем ответ. Делим ответ на отеьные буквы.
    private final int answerIndex = (int) (Math.random() * 4);
    final char[] answer = splitWordIntoLetters(answers[answerIndex]);
    // Глобальные переменные
    private char[] enteredLetters = new char[26];
    private int gameStage = 0;
    private char userLetter;
    private int guessedLetters = 0;
    private final int length = answers[answerIndex].length();
    public int attemptLeft = 7;
    // Формируемый ответ
    private char[] userWord = maskingTheWord(answers[answerIndex], guessedLetters);

    // Ввод буквы пользователем
    public String setLetter() {
        getDestiny();
        System.out.println(userWord);
        System.out.println("Input a letter: > ");
        String enteredLetter = scanner.next();
        userLetter = enteredLetter.charAt(0);
        return enteredLetter;
    }

    // Выполнение действий в зависимости от того, что вернула checkLetter
    public void makeDecisions() {
        int actinCode = checkLetter();
        getMistakeMessage(actinCode);
        if (actinCode == 0) {
            attemptLeft--;
        }
        // Добавляем букву в пулл уже введенных.
        gameStage++;
        enteredLetters[gameStage] = userLetter;
    }

    // Выполняет проверку того, что вводиться.
    public boolean letterCheck(String input) {
        boolean isLetter = (Character.isLowerCase(input.charAt(0)));
        if (splitWordIntoLetters(input).length > 1) { // Проврка на длину, с помощью разделения на массив отдельных char
            getMistakeMessage(4);
            isLetter = false;
        } else if (isLetter == false) {getMistakeMessage(3);} // Если случилос так, что была введена не маленькая латинкая буква.

        return isLetter;
    }

    // Определение "судьбы" игрока в зависимости от количества попыток
    private void getDestiny() {
        if (guessedLetters == length && attemptLeft > 1) {
            System.out.println("You guessed the word!\n" +
                    "You survived!");
            System.exit(0);
        }
        else if (attemptLeft == 0) {
            System.out.println("You lost!");
            System.exit(0);
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
    0 - нет буквы; 1 - буква есть, но игрок её уже нашел / два раза ввёл одну и туже букву; 2 - игрок угадал букву;*/
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
        if (checkEnteredLetters(userLetter) == true) {returnCode = 1;} // Проверка на повторный код.
        return returnCode;
    }

    // В зависимости введенного кода выдает соответствующее сообщение
    private void getMistakeMessage(int actionCode) {
        if (actionCode == 0) {System.out.println("That letter doesn't appear in the word");}
        else if (actionCode == 1) {System.out.println("You've already guessed this letter.");}
        else if (actionCode == 3) {System.out.println("Please enter a lowercase English letter.");}
        else if (actionCode == 4) {System.out.println("You should input a single letter.");}
    }

    // Проверка на повторный ввод.
    private boolean checkEnteredLetters(char letter) {
        boolean isLetterEntered = false;
        for (int i = 0; i < enteredLetters.length; i++) {
            if (enteredLetters[i] == letter) {
                isLetterEntered = true;
                break;
            }
        }
        return isLetterEntered;
    }
}
