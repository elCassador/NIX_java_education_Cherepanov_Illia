package nix.education.java.hangman;

public class hangmanMenu extends Menu{

    @Override
    void greetings() {
        System.out.println("HANGMAN");
    }

    @Override
    void start() {
        Hangman hangman = new Hangman();
        while (true) {
            hangman.setLetter();
            hangman.makeDecisions();
        }

    }

    @Override
    void exit() {
        System.exit(0);
    }
}
