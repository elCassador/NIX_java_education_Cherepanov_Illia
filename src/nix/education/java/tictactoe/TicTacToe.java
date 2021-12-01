package nix.education.java.tictactoe;

import java.util.Arrays;

public class TicTacToe extends FieldDraw implements FieldAnalys{

    protected char[][] GAME_FIELD = makeGameField(3, 3);
    private int FIELD_HORIZONTAL_LENGTH = getHorizontalLength(GAME_FIELD);
    private int FIELD_VERTICAL_LENGTH = getVerticalLength(GAME_FIELD);

    TicTacToeConstants ticTacToeConstants = new TicTacToeConstants();

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        FieldSet fieldFill = new FieldSet();
        GameTurn gameTurn = new GameTurn();
        String INPUT_STRING = "_________";
        fieldFill.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.FIELD_HORIZONTAL_LENGTH, ticTacToe.FIELD_VERTICAL_LENGTH);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        int TURN = 1;
        while (TURN <= ticTacToe.ticTacToeConstants.MAX_POSSIBLE_TURNS) {
            System.out.print("Enter coordinates: ");
            if (gameTurn.loop(ticTacToe, TURN, fieldFill)) {
                TURN += 1;
            }
        }
        ticTacToe.printGameResultMessage(ticTacToe.ticTacToeConstants.DRAW);
    }

    @Override
    public void horizontalCheckGameFieldState() {
        for (int x = 0; x < ticTacToeConstants.CHAR_PER_LINE; x++) {
            char[] eqArray = new char[ticTacToeConstants.CHAR_PER_LINE];
            for (int y = 0; y < ticTacToeConstants.CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[x][y];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void verticalCheckGameFieldState() {
        for (int x = 0; x < ticTacToeConstants.CHAR_PER_LINE; x++) {
            char[] eqArray = new char[ticTacToeConstants.CHAR_PER_LINE];
            for (int y = 0; y < ticTacToeConstants.CHAR_PER_LINE; y++) {
                eqArray[y] = GAME_FIELD[y][x];
            }
            isEqualToO(eqArray);
            isEqualToX(eqArray);
        }
    }

    @Override
    public void diagonalCheckGameFieldState() {
        char[] eqArrayRight = new char[ticTacToeConstants.CHAR_PER_LINE];
        char[] eqArrayLeft = new char[ticTacToeConstants.CHAR_PER_LINE];
        for (int i = 0; i < FIELD_VERTICAL_LENGTH; i++) {
            eqArrayRight[i] = GAME_FIELD[i][i];
            eqArrayLeft[i] = GAME_FIELD[ticTacToeConstants.CHAR_PER_LINE-1 - i][i];
        }
        isEqualToO(eqArrayRight);
        isEqualToX(eqArrayRight);

        isEqualToO(eqArrayLeft);
        isEqualToX(eqArrayLeft);
    }

    @Override
    public void isEqualToO(char[] FIRST) {
        if (Arrays.equals(FIRST, ticTacToeConstants.O_EXAMPLE)) {
            printGameResultMessage(ticTacToeConstants.O_WINS);
        }
    }

    @Override
    public void isEqualToX(char[] FIRST) {
        if (Arrays.equals(FIRST, ticTacToeConstants.X_EXAMPLE)) {
            printGameResultMessage(ticTacToeConstants.X_WINS);
        }
    }

    @Override
    public void printGameResultMessage(int END_GAME_CODE) {
        if (END_GAME_CODE == ticTacToeConstants.GAME_NOT_FINISHED) {
            System.out.println("game is not finished");
        }
        else if (END_GAME_CODE == ticTacToeConstants.DRAW) {
            System.out.println("Draw");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeConstants.X_WINS) {
            System.out.printf("X wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeConstants.O_WINS) {
            System.out.printf("O wins");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeConstants.IMPOSSIBLE) {
            System.out.printf("Impossible");
            System.exit(0);
        }
        else if (END_GAME_CODE == ticTacToeConstants.CELL_IS_OCCUPIED) {
            System.out.println("Cell is occupied");
        }
        else if (END_GAME_CODE == ticTacToeConstants.WRONG_INPUT_TYPE) {
            System.out.println("You should enter numbers!");
        }
        else if (END_GAME_CODE == ticTacToeConstants.COORDINATE_SHOULD_BE) {
            System.out.println("Coordinate should be from 1 to 3!");
        }
    }

    @Override
    public boolean isEmpty(int x, int y) {
        if (GAME_FIELD[x][y] == '_' || GAME_FIELD == null) {
            return true;
        }
        else {
            printGameResultMessage(ticTacToeConstants.CELL_IS_OCCUPIED);
            return false;
        }
    }
}
