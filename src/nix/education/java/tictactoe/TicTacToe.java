package nix.education.java.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe extends FieldDraw implements FieldAnalys{

    protected char[][] GAME_FIELD = makeGameField(3, 3);
    private int FIELD_HORIZONTAL_LENGTH = getHorizontalLength(GAME_FIELD);
    private int FIELD_VERTICAL_LENGTH = getVerticalLength(GAME_FIELD);

    TicTacToeVariables ticTacToeVariables = new TicTacToeVariables();

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        FieldSet fieldFill = new FieldSet();
        Scanner scanner = new Scanner(System.in);
        String INPUT_STRING = "_________";
        fieldFill.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.FIELD_HORIZONTAL_LENGTH, ticTacToe.FIELD_VERTICAL_LENGTH);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        int TURN = ticTacToe.ticTacToeVariables.X_TURN;
        char SYMBOL = ticTacToe.ticTacToeVariables.X_SYMBOL;
        int TURN_IS_MAKED = 0;
        while (TURN_IS_MAKED != ticTacToe.ticTacToeVariables.MAX_POSSIBLE_TURNS) {
            System.out.print("Enter the coordinates: ");
            if (TURN == 2) {
                TURN = ticTacToe.ticTacToeVariables.X_TURN;
                SYMBOL = ticTacToe.ticTacToeVariables.X_SYMBOL;
            }
            char INPUT_COORDINATES_X = scanner.next().charAt(0);
            if (Character.isDigit(INPUT_COORDINATES_X)) {
                char INPUT_COORDINATES_Y = scanner.next().charAt(0);
                if (Character.isDigit(INPUT_COORDINATES_Y)) {
                    if (ticTacToe.isEmpty(Character.getNumericValue(INPUT_COORDINATES_X) - 1, Character.getNumericValue(INPUT_COORDINATES_Y) - 1)) {
                        fieldFill.setTheSymbol(INPUT_COORDINATES_X, INPUT_COORDINATES_Y, ticTacToe.GAME_FIELD, SYMBOL);
                        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
                        ticTacToe.horizontalCheckGameFieldState();
                        ticTacToe.verticalCheckGameFieldState();
                        ticTacToe.diagonalCheckGameFieldState();
                        TURN += 1;
                        TURN_IS_MAKED += 1;
                        SYMBOL = ticTacToe.ticTacToeVariables.O_SYMBOL;
                    }
                } else {
                    ticTacToe.printGameResultMessage(ticTacToe.ticTacToeVariables.WRONG_INPUT_TYPE);
                }
            }
            ticTacToe.printGameResultMessage(ticTacToe.ticTacToeVariables.DRAW);
        }
    }

    @Override
    public void horizontalCheckGameFieldState() {
        for (int x = 0; x < ticTacToeVariables.CHAR_PER_LINE; x++) {
            char[] eqArray = new char[ticTacToeVariables.CHAR_PER_LINE];
            for (int y = 0; y < ticTacToeVariables.CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[x][y];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void verticalCheckGameFieldState() {
        for (int x = 0; x < ticTacToeVariables.CHAR_PER_LINE; x++) {
            char[] eqArray = new char[ticTacToeVariables.CHAR_PER_LINE];
            for (int y = 0; y < ticTacToeVariables.CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[y][x];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void diagonalCheckGameFieldState() {
        char[] eqArrayRight = new char[ticTacToeVariables.CHAR_PER_LINE];
        char[] eqArrayLeft = new char[ticTacToeVariables.CHAR_PER_LINE];
        for (int i = 0; i < FIELD_VERTICAL_LENGTH; i++) {
            eqArrayRight[i] = GAME_FIELD[i][i];
            eqArrayLeft[i] = GAME_FIELD[ticTacToeVariables.CHAR_PER_LINE-1 - i][i];
        }
        isEqualToO(eqArrayRight);
        isEqualToX(eqArrayRight);

        isEqualToO(eqArrayLeft);
        isEqualToX(eqArrayLeft);
    }

    @Override
    public void isEqualToO(char[] FIRST) {
        if (Arrays.equals(FIRST, ticTacToeVariables.O_EXAMPLE)) {
            printGameResultMessage(ticTacToeVariables.O_WINS);
        }
    }

    @Override
    public void isEqualToX(char[] FIRST) {
        if (Arrays.equals(FIRST, ticTacToeVariables.X_EXAMPLE)) {
            printGameResultMessage(ticTacToeVariables.X_WINS);
        }
    }

    @Override
    public void printGameResultMessage(int END_GAME_CODE) {
        if (END_GAME_CODE == ticTacToeVariables.GAME_NOT_FINISHED) {
            System.out.println("game is not finished");
        }
        else if (END_GAME_CODE == ticTacToeVariables.DRAW) {
            System.out.println("Draw");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeVariables.X_WINS) {
            System.out.printf("X wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeVariables.O_WINS) {
            System.out.printf("O wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeVariables.IMPOSSIBLE) {
            System.out.printf("Impossible");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeVariables.CELL_IS_OCCUPIED) {
            System.out.println("Cell is occupied");
        }
        else if (END_GAME_CODE == ticTacToeVariables.WRONG_INPUT_TYPE) {
            System.out.println("You should enter numbers!");
        }
    }

    @Override
    public boolean isEmpty(int x, int y) {
        if (GAME_FIELD[x][y] == '_' || GAME_FIELD == null) {
            return true;
        }
        else {
            printGameResultMessage(ticTacToeVariables.CELL_IS_OCCUPIED);
            return false;
        }
    }
}
