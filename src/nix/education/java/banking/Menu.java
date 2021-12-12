package nix.education.java.banking;

class Menu {

    protected BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();

    public void getOptions(String menu_type) {
        if (menu_type.equals(bankingSystemConstants.ACCOUNT_MENU)) {
            System.out.println(bankingSystemConstants.ACCOUNT_MENU_OPTIONS);
        }
        else {
            System.out.println(bankingSystemConstants.OPERATIONS_MENU_OPTIONS);
        }
    }

}
