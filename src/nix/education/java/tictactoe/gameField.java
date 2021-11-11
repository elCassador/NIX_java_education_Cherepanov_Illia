package nix.education.java.tictactoe;
import java.util.Scanner;


abstract class gameField {

    final int ADDITIONAL_HORIZONTAL_FRAME_LENGTH = 2;
    final int ADDITIONAL_VERTICAL_FRAME_LENGTH = 6;
    private int WRONG_CHARACTER_CODE = 1;
    private int WRONG_LENGTH_CODE = 2;

    public char[][] makeGameField(int x, int y) {
        char[][] gameField = new char[x][y];
        return gameField;
    }

    private final boolean checkInputSymbols(char SYMBOL) {
        if (SYMBOL == '0' || SYMBOL == 'O' || SYMBOL == 'X' || SYMBOL == '_') {
            return true;
        }
        else {
            return false;
        }
    }

    private final boolean checkInputLength(char[][] original, String entered) {
        if (original.length * original[0].length == entered.length()) {
            return true;
        }
        else {
            return false;
        }
    }

    private void errorMssagesOutput(int ERROR_CODE) {
        if (ERROR_CODE == WRONG_CHARACTER_CODE) {
            System.out.println("Недопустимый символ!");
        }
        else if (ERROR_CODE == WRONG_LENGTH_CODE) {
            System.out.println("Недопустимая длина строки!");
        }
        System.exit(1);
    }

    public void setTheSymbols(String INPUT_STRING, char[][] gameField, int VERTICAL_LENGTH, int HORIZONTAL_LENGTH) {
        int counter = 0;
        if (checkInputLength(gameField, INPUT_STRING)) {
            for (int x = 0; x < HORIZONTAL_LENGTH; x++ ) {
                for (int y = 0; y < VERTICAL_LENGTH; y++ ) {
                    if (checkInputSymbols(INPUT_STRING.charAt(counter))) {
                        gameField[x][y] = INPUT_STRING.charAt(counter);
                        counter += 1;
                    }
                    else {
                        errorMssagesOutput(WRONG_CHARACTER_CODE);
                    }
                }
            }
        }
        else {
            errorMssagesOutput(WRONG_LENGTH_CODE);
        }
    }

    private final void drawHorizontalFrame(int y, int LENGTH_Y) {
        if (y < LENGTH_Y - 1) {
            System.out.print('-');
        }
        else {
            System.out.println('-');
        }
    }

    private final void drawLeftVerticalFrame() {
        System.out.print("| ");
    }

    private final void drawRightVerticalFrame() {
        System.out.println("|");
    }

    public void drawGameField(char[][] gameField) {
        int LENGTH_X = gameField.length + ADDITIONAL_HORIZONTAL_FRAME_LENGTH;
        int LENGTH_Y = gameField[0].length + ADDITIONAL_VERTICAL_FRAME_LENGTH;
        for (int x = 0; x < LENGTH_X; x++) {
            for (int y = 0; y < LENGTH_Y; y++) {
                if (x == 0 || x == LENGTH_X - 1) {
                    drawHorizontalFrame(y, LENGTH_Y);
                }
                else if (y == 0) {
                    drawLeftVerticalFrame();
                }
                else if (y == LENGTH_Y - 1) {
                    drawRightVerticalFrame();
                }
                else if (y >= 2 && y <= 4){
                    System.out.print(gameField[x - 1][y - 2] + " ");
                }
            }
        }
    }

    public int getHorizontalLength(char[][] GAME_FIELD) {
        return GAME_FIELD.length;
    }

    public int getVerticalLength(char[][] GAME_FIELD) {
        return GAME_FIELD[0].length;
    }
}
