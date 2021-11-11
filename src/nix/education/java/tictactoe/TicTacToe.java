package nix.education.java.tictactoe;

import java.util.Scanner;

public class TicTacToe extends Game {

    protected char[][] GAME_FIELD = makeGameField(3, 3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
        System.out.print("Enter cells: ");
        String INPUT_STRING = scanner.nextLine();
        ticTacToe.setTheSymbols(INPUT_STRING, ticTacToe.GAME_FIELD, ticTacToe.GAME_FIELD.length, ticTacToe.GAME_FIELD[0].length);
        ticTacToe.drawGameField(ticTacToe.GAME_FIELD);
    }

}
