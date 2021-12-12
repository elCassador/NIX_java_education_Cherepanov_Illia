public class BankingSystemConstants {
    final int CREATE_ACCOUNT_OR_BALANCE = 1;
    final int LOG_INTO_OR_ADD_INCOME = 2;
    final int DO_TRANSFER = 3;
    final int CLOSE_ACCOUNT = 4;
    final int LOG_OUT = 5;
    final int EXIT = 0;
    final int INN_LENGTH = 9;
    final int PIN_LENGTH = 4;
    final int START_BALANCE = 0;

    final String ACCOUNT_MENU = "account menu";
    final String ACCOUNT_MENU_OPTIONS = "1. Balance\n2. Add income\n3. Do transfer\n4. Close account\n5. Log out\n0. Exit";

    final String OPERATIONS_MENU = "operations menu";
    final String OPERATIONS_MENU_OPTIONS = "1. Create an account\n2. Log into account\n0. Exit";


    final String ERROR_INN = "Wrong card number!";
    final String ERROR_PIN = "Wrong PIN!";

    final String ID_COLUMN = "id";
    final String NUMBER_COLUMN = "number";
    final String PIN_COLUMN = "pin";
    final String BALANCE_COLUMN = "balance";

    final int THREAD_OPERATION_MENU = 1;
    final int THREAD_ACCOUNT_MENU = 2;
}
