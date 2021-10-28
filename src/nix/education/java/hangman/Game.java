package nix.education.java.hangman;

public class Game {

    public static void main(String[] args) {
        hangmanMenu game = new hangmanMenu();
        game.greetings();
        game.start();
    }
}
