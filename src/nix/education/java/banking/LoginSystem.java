package nix.education.java.banking;

import java.util.Scanner;

public class LoginSystem {

    private Scanner scanner = new Scanner(System.in);
    private BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();
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
        int id = db.getIntValue(bankingSystemConstants.NUMBER_COLUMN, user_inn, bankingSystemConstants.ID_COLUMN);
        if (id == 0) {
            System.out.println(bankingSystemConstants.ERROR_INN);
        }
        else {
            String pin = db.getStringValue(bankingSystemConstants.NUMBER_COLUMN, user_inn, bankingSystemConstants.PIN_COLUMN);
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
            System.out.println(bankingSystemConstants.ERROR_PIN);
        }
    }
}
