package nix.education.java.tictactoe;

import java.util.Scanner;

public class TicTacToe extends gameField implements FieldAnalys{

    protected char[][] GAME_FIELD = makeGameField(3, 3);
    private int FIELD_HORIZONTAL_LENGTH = getHorizontalLength(GAME_FIELD);
    private int FIELD_VERTICAL_LENGTH = getVerticalLength(GAME_FIELD);

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        System.out.print("Enter cells: ");
        String INPUT_STRING = scanner.nextLine();
        ticTacToe.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.FIELD_HORIZONTAL_LENGTH, ticTacToe.FIELD_VERTICAL_LENGTH);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
    }

    @Override
    public void horizontalCheckGameFieldState() {
        for (int x = 0; x < FIELD_HORIZONTAL_LENGTH; x++) {
            int FIND_MATCHING = 0;
            for (int y = 0; y < FIELD_VERTICAL_LENGTH; y++) {
                if (GAME_FIELD[x][y] == GAME_FIELD)
            }
        }
    }

    @Override
    public void verticalCheckGameFieldState() {

    }

    @Override
    public void diagonalCheckGameFieldState() {

    }

    @Override
    public boolean isSame(char FIRST, char SECOND) {
        if (FIRST == SECOND) {
            return true;
        }
        else {
            return false;
        }
    }
}
