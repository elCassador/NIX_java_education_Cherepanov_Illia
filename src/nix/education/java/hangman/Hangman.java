package nix.education.java.hangman;
import java.util.Scanner;

final class Hangman {

    private final Scanner scanner = new Scanner(System.in);

    private final String[] answers = new String[] {"java", "python", "javascript", "kotlin"};
    // Опрееляем ответ. Делим ответ на отеьные буквы.
    private final int ANSWER_INDEX = (int) (Math.random() * 4);
    final char[] ANSWER = splitWordIntoLetters(answers[ANSWER_INDEX]);
    // Глобальные переменные
    private char[] enteredLetters = new char[26];
    private int GAME_STAGE = 0;
    private char USER_LETTER;
    private int GUESSED_LETTERS = 0;
    private final int LENGTH = answers[ANSWER_INDEX].length();
    public int ATTEMPT_LEFT = 7;
    public static final int NOT_APPEARED_LETTER = 0;
    public static final int ALREADY_GUESSED_LETTER = 1;
    public static final int EVERYTHING_IS_OK = 2;
    public static final int WRONG_CASE_LETTER = 3;
    public static final int WRONG_NUMBER_OF_LETTERS = 4;
    // Формируемый ответ
    private char[] userWord = maskingTheWord(answers[ANSWER_INDEX], GUESSED_LETTERS);

    // Ввод буквы пользователем
    public String setLetter() {
        getDestiny();
        System.out.println(userWord);
        System.out.println("Input a letter: > ");
        String enteredLetter = scanner.next();
        USER_LETTER = enteredLetter.charAt(0);
        return enteredLetter;
    }

    // Выполнение действий в зависимости от того, что вернула checkLetter
    public void makeDecisions() {
        int actinCode = checkLetter();
        getMistakeMessage(actinCode);
        if (actinCode == NOT_APPEARED_LETTER) {
            ATTEMPT_LEFT--;
        }
        // Добавляем букву в пулл уже введенных.
        GAME_STAGE++;
        enteredLetters[GAME_STAGE] = USER_LETTER;
    }

    // Выполняет проверку того, что вводиться.
    public boolean letterCheck(String input) {
        boolean isLetter = (Character.isLowerCase(input.charAt(0)));
        if (splitWordIntoLetters(input).length > 1) { // Проврка на длину, с помощью разделения на массив отдельных char
            getMistakeMessage(WRONG_NUMBER_OF_LETTERS);
            isLetter = false;
        } else if (isLetter == false) { // Если случилос так, что была введена не маленькая латинкая буква.
            getMistakeMessage(WRONG_CASE_LETTER);
        }

        return isLetter;
    }

    // Определение "судьбы" игрока в зависимости от количества попыток
    public boolean getDestiny() {
        if (GUESSED_LETTERS == LENGTH && ATTEMPT_LEFT > 1) {
            System.out.println("You guessed the word!\n" +
                    "You survived!");
            return false;
        }
        else if (ATTEMPT_LEFT == 0) {
            System.out.println("You lost!");
            return false;
        } else {
            return true;
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
        int returnCode = NOT_APPEARED_LETTER;
        for (int i = 0; i < LENGTH; i++) {
            if (USER_LETTER == ANSWER[i]) {
                if (USER_LETTER != userWord[i]) { // Отсекает вариант, когда пользователь пытается ввести уже введенную букву
                    userWord[i] = USER_LETTER;
                    returnCode = EVERYTHING_IS_OK;
                    GUESSED_LETTERS++; // Количество угаданных букв
                } else {
                    returnCode = ALREADY_GUESSED_LETTER ;
                }
            }
        }
        if (checkEnteredLetters(USER_LETTER)) { // Проверка на повторный код.
            returnCode = ALREADY_GUESSED_LETTER;
        }
        return returnCode;
    }

    // В зависимости введенного кода выдает соответствующее сообщение
    private void getMistakeMessage(int actionCode) {
        if (actionCode == NOT_APPEARED_LETTER) {
            System.out.println("That letter doesn't appear in the word");
        }
        else if (actionCode == ALREADY_GUESSED_LETTER) {
            System.out.println("You've already guessed this letter.");
        }
        else if (actionCode == WRONG_CASE_LETTER) {
            System.out.println("Please enter a lowercase English letter.");
        }
        else if (actionCode == WRONG_NUMBER_OF_LETTERS) {
            System.out.println("You should input a single letter.");
        }
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
