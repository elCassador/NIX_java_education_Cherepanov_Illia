package nix.education.java.hangman;

public class hangmanMenu extends Menu implements repeatMessage{



    @Override
    void greetings() {
        System.out.println("HANGMAN");
    }

    @Override
    void start() {
        Hangman hangman = new Hangman();
        while (hangman.getDestiny()) {
            String enterdLetter = hangman.setLetter();
            boolean isLetter = hangman.letterCheck(enterdLetter);
            if (isLetter) {
                hangman.makeDecisions();
            }
        }
        System.out.println(" ");
        doRepeatMessage();

    }

    @Override
    void exit() {
        System.exit(0);
    }

    @Override
    public void doRepeatMessage() {
        System.out.println("Type \"play\" to play the game, \"exit\" to quit:");
    }
}
