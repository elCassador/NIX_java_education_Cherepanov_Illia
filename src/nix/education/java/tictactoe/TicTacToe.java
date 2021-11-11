package nix.education.java.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe extends gameField implements FieldAnalys{

    protected char[][] GAME_FIELD = makeGameField(3, 3);
    private int FIELD_HORIZONTAL_LENGTH = getHorizontalLength(GAME_FIELD);
    private int FIELD_VERTICAL_LENGTH = getVerticalLength(GAME_FIELD);
    private int MAX_POSSIBLE_TURNS = 9;
    final char X_SYMBOL = 'X';
    final char O_SYMBOL = 'O';
    final int X_TURN = 0;
    final int O_TURN = 1;
    final int CHAR_PER_LINE = 3;
    final int GAME_NOT_FINISHED = 1;
    final int DRAW = 2;
    final int X_WINS = 3;
    final int O_WINS = 4;
    final int IMPOSSIBLE = 5;
    final int CELL_IS_OCCUPIED = 6;
    final int WRONG_INPUT_TYPE = 7;

    final char[] O_EXAMPLE = {'O', 'O', 'O'};
    final char[] X_EXAMPLE = {'X', 'X', 'X'};

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        FieldFill fieldFill = new FieldFill();
        Scanner scanner = new Scanner(System.in);
        String INPUT_STRING = "_________";
        fieldFill.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.FIELD_HORIZONTAL_LENGTH, ticTacToe.FIELD_VERTICAL_LENGTH);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        int TURN = ticTacToe.X_TURN;
        char SYMBOL = ticTacToe.X_SYMBOL;
        int TURN_IS_MAKED = 0;
        while (TURN_IS_MAKED != ticTacToe.MAX_POSSIBLE_TURNS) {
            System.out.print("Enter the coordinates: ");
            if (TURN == 2) {
                TURN = ticTacToe.X_TURN;
                SYMBOL = ticTacToe.X_SYMBOL;
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
                        SYMBOL = ticTacToe.O_SYMBOL;
                    }
                } else {
                    ticTacToe.printGameResultMessage(ticTacToe.WRONG_INPUT_TYPE);
                }
            }
            ticTacToe.printGameResultMessage(ticTacToe.DRAW);
        }
    }

    @Override
    public void horizontalCheckGameFieldState() {
        for (int x = 0; x < CHAR_PER_LINE; x++) {
            char[] eqArray = new char[CHAR_PER_LINE];
            for (int y = 0; y < CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[x][y];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void verticalCheckGameFieldState() {
        for (int x = 0; x < CHAR_PER_LINE; x++) {
            char[] eqArray = new char[CHAR_PER_LINE];
            for (int y = 0; y < CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[y][x];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void diagonalCheckGameFieldState() {
        char[] eqArrayRight = new char[CHAR_PER_LINE];
        char[] eqArrayLeft = new char[CHAR_PER_LINE];
        for (int i = 0; i < FIELD_VERTICAL_LENGTH; i++) {
            eqArrayRight[i] = GAME_FIELD[i][i];
            eqArrayLeft[i] = GAME_FIELD[CHAR_PER_LINE-1 - i][i];
        }
        isEqualToO(eqArrayRight);
        isEqualToX(eqArrayRight);

        isEqualToO(eqArrayLeft);
        isEqualToX(eqArrayLeft);
    }

    @Override
    public void isEqualToO(char[] FIRST) {
        if (Arrays.equals(FIRST, O_EXAMPLE)) {
            printGameResultMessage(O_WINS);
        }
    }

    @Override
    public void isEqualToX(char[] FIRST) {
        if (Arrays.equals(FIRST, X_EXAMPLE)) {
            printGameResultMessage(X_WINS);
        }
    }

    @Override
    public void printGameResultMessage(int END_GAME_CODE) {
        if (END_GAME_CODE == GAME_NOT_FINISHED) {
            System.out.println("game is not finished");
        }
        else if (END_GAME_CODE == DRAW) {
            System.out.println("Draw");
            System.exit(0);
        }
        else if (END_GAME_CODE == X_WINS) {
            System.out.printf("X wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == O_WINS) {
            System.out.printf("O wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == IMPOSSIBLE) {
            System.out.printf("Impossible");
            System.exit(0);
        }
        else if (END_GAME_CODE == CELL_IS_OCCUPIED) {
            System.out.println("Cell is occupied");
        }
        else if (END_GAME_CODE == WRONG_INPUT_TYPE) {
            System.out.println("You should enter numbers!");
        }
    }

    @Override
    public boolean isEmpty(int x, int y) {
        if (GAME_FIELD[x][y] == '_' || GAME_FIELD == null) {
            return true;
        }
        else {
            printGameResultMessage(CELL_IS_OCCUPIED);
            return false;
        }
    }
}
