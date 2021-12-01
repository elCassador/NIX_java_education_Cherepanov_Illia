package nix.education.java.hangman;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        hangmanMenu game = new hangmanMenu();
        GameIni menu = new GameIni();
        game.greetings();
        game.doRepeatMessage();
        while (true) {
            menu.checkInput(game);
        }
    }

}

final class GameIni {

    Scanner scanner = new Scanner(System.in);

    public void checkInput(hangmanMenu game) {
        String inputString = scanner.nextLine();
        if (inputString.equals("play")) {
            game.start();
        }
        else if (inputString.equals("exit")) {
            game.exit();
        }
        else {
            game.doRepeatMessage();
        }
    }
}
