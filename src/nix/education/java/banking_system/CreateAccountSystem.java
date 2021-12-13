package nix.education.java.banking_system;

import java.util.Random;

public class CreateAccountSystem {

    private Random rand = new Random();
    Luna luna = new Luna();
    Connect db = new Connect();

    public void getNewAccount() {
        String  INN = getINN();
        String PIN = getPIN();
        int id;
        System.out.println("Your card has been created");
        System.out.println("Your card number:\n" + INN);
        System.out.println("Your card PIN:\n" + PIN);
        id = db.getMaxId();
        db.insertCard(id + 1, INN, PIN, 0);
    }

    private String getINN() {
        String account_number = "400000";
        for (int i = 0; i < BankingSystemConstants.INN_LENGTH; i++) {
            account_number += Integer.toString(rand.nextInt(9));
        }
        String correct_account_INN = luna.getCorrectINN(account_number);
        return correct_account_INN;
    }

    private String getPIN() {
        String pin_number = "";
        for (int i = 0; i < BankingSystemConstants.PIN_LENGTH; i++) {
            pin_number += Integer.toString(rand.nextInt(9));
        }
        return pin_number;
    }
}