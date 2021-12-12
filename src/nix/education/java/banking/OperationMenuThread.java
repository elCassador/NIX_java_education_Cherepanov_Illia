package nix.education.java.banking;

import java.util.Scanner;

public class OperationMenuThread extends Thread{

    @Override
    public void run() {
        BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();
        Scanner scanner = new Scanner(System.in);
        MenuOperations menuOperations = new MenuOperations();
        boolean isActive = true;
        while (isActive) {
            menuOperations.getOptions(bankingSystemConstants.OPERATIONS_MENU_OPTIONS);
            isActive = menuOperations.setOption(scanner.nextInt());
        }
    }
}
