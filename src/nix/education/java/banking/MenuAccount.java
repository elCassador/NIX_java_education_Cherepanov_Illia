import java.util.Scanner;

public class MenuAccount extends Menu implements ChooseOption{

    private TransferTool transferTool = new TransferTool();
    private Connect db = new Connect();
    private Scanner scanner = new Scanner(System.in);
    private String account_number; //value_column

    public void setAccountNumber(String number) {
        account_number = number;
    }

    @Override
    public boolean setOption(int operation) {
        if (operation == bankingSystemConstants.CREATE_ACCOUNT_OR_BALANCE) {
            int balance =  db.getIntValue(bankingSystemConstants.NUMBER_COLUMN, account_number, bankingSystemConstants.BALANCE_COLUMN);
            System.out.println(balance);
        }
        else if (operation == bankingSystemConstants.LOG_INTO_OR_ADD_INCOME) {
            System.out.println("Enter income");
            int income = scanner.nextInt();
            db.increaseBalance(account_number, income);
        }
        else if (operation == bankingSystemConstants.DO_TRANSFER) {
            System.out.println("Transfer\nEnter card number: ");
            String transfer_number = scanner.next();
            transferTool.transferMoney(account_number, transfer_number);
        }
        else if (operation == bankingSystemConstants.CLOSE_ACCOUNT) {
            db.removeAccount(account_number);
            return false;
        }
        else if (operation == bankingSystemConstants.LOG_OUT) {
            return false;
        }
        else if (operation == bankingSystemConstants.EXIT) {
            System.exit(0);
        }
        return true;
    }
}
