package nix.education.java.banking;

public class MenuOperations extends Menu implements ChooseOption{

    private CreateAccountSystem createNewAccount = new CreateAccountSystem();
    private LoginSystem loginSystem = new LoginSystem();

    @Override
    public boolean setOption(int operation) {
        if (operation == bankingSystemConstants.CREATE_ACCOUNT_OR_BALANCE) {
            createNewAccount.getNewAccount();
        }
        else if (operation == bankingSystemConstants.LOG_INTO_OR_ADD_INCOME) {
            loginSystem.setUserData();
        }
        else if (operation == bankingSystemConstants.EXIT) {
            return false;
        }
        return true;
    }
}
