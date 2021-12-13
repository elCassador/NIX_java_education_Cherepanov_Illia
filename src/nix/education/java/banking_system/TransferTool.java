package nix.education.java.banking_system;

import java.util.Scanner;

public class TransferTool {

    private Luna luna = new Luna();
    private Scanner scanner = new Scanner(System.in);
    private String transfer_number;
    private String account_number;
    private int transfer_value;
    private Connect db = new Connect();

    public void transferMoney(String number, String transfer) {
        account_number = number;
        transfer_number = transfer;
        checkWithLuna();
    }

    private void checkWithLuna() {
        boolean check_res = luna.checkLuna(transfer_number);
        if (check_res == false) {
            System.out.println("Probably you made a mistake in the card number. Please try again!");
        }
        else {
            checkTransferNumber();
        }
    }

    private void checkTransferNumber() {
        int id = db.getIntValue(BankingSystemConstants.NUMBER_COLUMN, transfer_number, BankingSystemConstants.ID_COLUMN);
        if (account_number.equals(transfer_number)) {
            System.out.println("You can't transfer money to the same account!");
        }
        else if (id == 0) {
            System.out.println("Such a card does not exist.");
        }
        else {
            checkAvailableBalance();
        }
    }

    private void checkAvailableBalance() {
        int account_balance = db.getIntValue(BankingSystemConstants.NUMBER_COLUMN, account_number, BankingSystemConstants.BALANCE_COLUMN);
        System.out.println("Enter how much money you want to transfer:");
        transfer_value = scanner.nextInt();
        if (account_balance < transfer_value) {
            System.out.println("Not enough money!");
        }
        else {
            db.decreaseBalance(account_number, transfer_value);
            db.increaseBalance(transfer_number, transfer_value);
            System.out.println("Success");
        }
    }
}