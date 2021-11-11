package nix.education.java.tictactoe;

public class FieldSet {

    TicTacToeVariables ticTacToeVariables = new TicTacToeVariables();

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
                        errorMssagesOutput(ticTacToeVariables.WRONG_CHARACTER_CODE);
                    }
                }
            }
        }
        else {
            errorMssagesOutput(ticTacToeVariables.WRONG_LENGTH_CODE);
        }
    }

    public void setTheSymbol(char x, char y, char[][] GAME_FIELD, char SYMBOL) {
        GAME_FIELD[x - 1][y - 1] = SYMBOL;
    }
}
