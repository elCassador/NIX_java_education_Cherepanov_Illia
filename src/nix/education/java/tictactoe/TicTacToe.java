package nix.education.java.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe extends gameField implements FieldAnalys{

    protected char[][] GAME_FIELD = makeGameField(3, 3);
    private int FIELD_HORIZONTAL_LENGTH = getHorizontalLength(GAME_FIELD);
    private int FIELD_VERTICAL_LENGTH = getVerticalLength(GAME_FIELD);
    final int CHAR_PER_LINE = 3;
    final int GAME_NOT_FINISHED = 1;
    final int DRAW = 2;
    final int X_WINS = 3;
    final int O_WINS = 4;
    final int IMPOSSIBLE = 5;

    final char[] O_EXAMPLE = {'O', 'O', 'O'};
    final char[] X_EXAMPLE = {'X', 'X', 'X'};

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        System.out.print("Enter cells: ");
        String INPUT_STRING = scanner.nextLine();
        ticTacToe.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.FIELD_HORIZONTAL_LENGTH, ticTacToe.FIELD_VERTICAL_LENGTH);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        ticTacToe.horizontalCheckGameFieldState();
        ticTacToe.verticalCheckGameFieldState();
        ticTacToe.diagonalCheckGameFieldState();
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
        }
        else if (END_GAME_CODE == X_WINS) {
            System.out.printf("X wins");
        }
        else if (END_GAME_CODE == O_WINS) {
            System.out.printf("O wins");
        }
        else if (END_GAME_CODE == IMPOSSIBLE) {
            System.out.printf("Impossible");
        }
    }

}
