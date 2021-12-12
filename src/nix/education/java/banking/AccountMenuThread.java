import java.util.Scanner;

public class AccountMenuThread implements Runnable{

    String user_inn;

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();
        MenuAccount menuAccount = new MenuAccount();
        boolean account_in_use = true;
        while (account_in_use) {
            menuAccount.setAccountNumber(user_inn);
            menuAccount.getOptions(bankingSystemConstants.ACCOUNT_MENU);
            int option = scanner.nextInt();
            account_in_use = menuAccount.setOption(option);
        }
    }

    public void setAccountNumber(String number) {
        user_inn = number;
    }
}
