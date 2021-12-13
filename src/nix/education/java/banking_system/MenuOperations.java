package nix.education.java.banking_system;

public class MenuOperations extends Menu implements ChooseOption{

    private CreateAccountSystem createNewAccount = new CreateAccountSystem();
    private LoginSystem loginSystem = new LoginSystem();

    @Override
    public boolean setOption(int operation) {
        if (operation == BankingSystemConstants.CREATE_ACCOUNT_OR_BALANCE) {
            createNewAccount.getNewAccount();
        }
        else if (operation == BankingSystemConstants.LOG_INTO_OR_ADD_INCOME) {
            loginSystem.setUserData();
        }
        else if (operation == BankingSystemConstants.EXIT) {
            return false;
        }
        return true;
    }
}