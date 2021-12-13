package nix.education.java.banking_system;

public class BankingSystemConstants {
    static int CREATE_ACCOUNT_OR_BALANCE = 1;
    static int LOG_INTO_OR_ADD_INCOME = 2;
    static int DO_TRANSFER = 3;
    static int CLOSE_ACCOUNT = 4;
    static int LOG_OUT = 5;
    static int EXIT = 0;
    static int INN_LENGTH = 9;
    static int PIN_LENGTH = 4;
    static int START_BALANCE = 0;

    static String ACCOUNT_MENU = "account menu";
    static String ACCOUNT_MENU_OPTIONS = "1. Balance\n2. Add income\n3. Do transfer\n4. Close account\n5. Log out\n0. Exit";

    static String OPERATIONS_MENU = "operations menu";
    static String OPERATIONS_MENU_OPTIONS = "1. Create an account\n2. Log into account\n0. Exit";


    static String ERROR_INN = "Wrong card number!";
    static String ERROR_PIN = "Wrong PIN!";

    static String ID_COLUMN = "id";
    static String NUMBER_COLUMN = "number";
    static String PIN_COLUMN = "pin";
    static String BALANCE_COLUMN = "balance";

    static int THREAD_OPERATION_MENU = 1;
    static int THREAD_ACCOUNT_MENU = 2;
}