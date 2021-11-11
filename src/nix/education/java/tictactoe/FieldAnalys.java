package nix.education.java.tictactoe;

import java.util.ArrayList;
import java.util.List;

interface FieldAnalys {



    void horizontalCheckGameFieldState();

    void verticalCheckGameFieldState();

    void diagonalCheckGameFieldState();

    void isEqualToO(char[] FIRST);

    void isEqualToX(char[] FIRST);

    void printGameResultMessage(int END_GAME_CODE);

}
