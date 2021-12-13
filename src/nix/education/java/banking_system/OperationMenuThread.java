package nix.education.java.banking_system;

import java.util.Scanner;

public class OperationMenuThread extends Thread{

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        MenuOperations menuOperations = new MenuOperations();
        boolean isActive = true;
        while (isActive) {
            menuOperations.getOptions(BankingSystemConstants.OPERATIONS_MENU_OPTIONS);
            isActive = menuOperations.setOption(scanner.nextInt());
        }
    }
}