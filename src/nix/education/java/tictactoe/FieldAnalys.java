package nix.education.java.tictactoe;

interface FieldAnalys {

    void horizontalCheckGameFieldState();

    void verticalCheckGameFieldState();

    void diagonalCheckGameFieldState();

    void isEqualToO(char[] FIRST);

    void isEqualToX(char[] FIRST);

    void printGameResultMessage(int END_GAME_CODE);

    boolean isEmpty(int x, int y);

}
