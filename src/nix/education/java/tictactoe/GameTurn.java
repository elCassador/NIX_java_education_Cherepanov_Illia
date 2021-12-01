package nix.education.java.tictactoe;

import java.util.Scanner;

public class GameTurn {

    public boolean loop(TicTacToe ticTacToe, int TURN, FieldSet fieldFill) {

        try {

            char SYMBOL;

            if (TURN % 2 == 0) {
                SYMBOL = ticTacToe.ticTacToeConstants.O_SYMBOL;
            } else {
                SYMBOL = ticTacToe.ticTacToeConstants.X_SYMBOL;
            }

            Scanner scanner = new Scanner(System.in);

            char INPUT_COORDINATES_X = scanner.next().charAt(0);
            char INPUT_COORDINATES_Y = scanner.next().charAt(0);

            if (!coordinatesCheck(INPUT_COORDINATES_X, INPUT_COORDINATES_Y)) {
                ticTacToe.printGameResultMessage(ticTacToe.ticTacToeConstants.WRONG_INPUT_TYPE);
            }

            if (ticTacToe.isEmpty(Character.getNumericValue(INPUT_COORDINATES_X) - 1, Character.getNumericValue(INPUT_COORDINATES_Y) - 1)) {
                fieldFill.setTheSymbol(INPUT_COORDINATES_X - '0', INPUT_COORDINATES_Y - '0', ticTacToe.GAME_FIELD, SYMBOL);
                ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
                ticTacToe.horizontalCheckGameFieldState();
                ticTacToe.verticalCheckGameFieldState();
                ticTacToe.diagonalCheckGameFieldState();
                return true;
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            ticTacToe.printGameResultMessage(ticTacToe.ticTacToeConstants.COORDINATE_SHOULD_BE);
            return false;
        }
        return false;
    }

    private boolean coordinatesCheck(char INPUT_COORDINATES_X, char INPUT_COORDINATES_Y) {
        if (Character.isDigit(INPUT_COORDINATES_X) && Character.isDigit(INPUT_COORDINATES_Y)) {
            return true;
        }
        return false;
    }
}
