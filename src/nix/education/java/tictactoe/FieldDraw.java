package nix.education.java.tictactoe;
import java.util.Scanner;


abstract class FieldDraw {

    TicTacToeVariables ticTacToeVariables = new TicTacToeVariables();

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
        if (ERROR_CODE == ticTacToeVariables.WRONG_CHARACTER_CODE) {
            System.out.println("Недопустимый символ!");
        }
        else if (ERROR_CODE == ticTacToeVariables.WRONG_LENGTH_CODE) {
            System.out.println("Недопустимая длина строки!");
        }
        System.exit(1);
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
        int LENGTH_X = gameField.length + ticTacToeVariables.ADDITIONAL_HORIZONTAL_FRAME_LENGTH;
        int LENGTH_Y = gameField[0].length + ticTacToeVariables.ADDITIONAL_VERTICAL_FRAME_LENGTH;
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
