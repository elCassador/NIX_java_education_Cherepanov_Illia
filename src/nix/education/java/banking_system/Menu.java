package nix.education.java.banking_system;

class Menu {

    public void getOptions(String menu_type) {
        if (menu_type.equals(BankingSystemConstants.ACCOUNT_MENU)) {
            System.out.println(BankingSystemConstants.ACCOUNT_MENU_OPTIONS);
        }
        else {
            System.out.println(BankingSystemConstants.OPERATIONS_MENU_OPTIONS);
        }
    }

}