package nix.education.java.banking_system;

import java.util.Scanner;

public class LoginSystem {

    private Scanner scanner = new Scanner(System.in);
    private MenuAccount menuAccount = new MenuAccount();
    private Connect db = new Connect();
    private String user_inn;
    private String user_pin;
    protected int id;
    private boolean account_in_use = false;
    AccountMenuThread accountMenuThread = new AccountMenuThread();


    public int setUserData() {
        System.out.println("Enter your card number:");
        user_inn = scanner.next();
        System.out.println("Enter your PIN:");
        user_pin = scanner.next();
        id = dataMatching();
        return id;
    }

    private int dataMatching() {
        int id = db.getIntValue(BankingSystemConstants.NUMBER_COLUMN, user_inn, BankingSystemConstants.ID_COLUMN);
        if (id == 0) {
            System.out.println(BankingSystemConstants.ERROR_INN);
        }
        else {
            String pin = db.getStringValue(BankingSystemConstants.NUMBER_COLUMN, user_inn, BankingSystemConstants.PIN_COLUMN);
            startThread(pin);
        }
        return id;
    }

    private void startThread(String pin) {
        if (user_pin.equals(pin)) {
            accountMenuThread.setAccountNumber(user_inn);
            accountMenuThread.run();
        }
        else {
            System.out.println(BankingSystemConstants.ERROR_PIN);
        }
    }
}