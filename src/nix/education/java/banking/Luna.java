public class Luna {

    BankingSystemConstants bankingSystemConstants = new BankingSystemConstants();

    public String getCorrectINN(String user_inn) {
        String[] INN = user_inn.split("");
        int checksum = 0;
        for (int i = 0; i < 15; i++) {
            int p = Integer.valueOf(INN[i]);
            if (i%2 == 0) {
                p = 2 * p;
                if (p > 9) {
                    p = p - 9;
                }
            }
            checksum += p;
        }
        int control = 10 - checksum%10;
        if (control == 10) {
            control = 0;
        }
        user_inn += control;
        return user_inn;

    }

    public boolean checkLuna(String user_inn) {
        boolean res = false;
        String[] INN = user_inn.split("");
        int checksum = 0;
        for (int i = 0; i < 16; i++) {
            int p = Integer.valueOf(INN[i]);
            if (i%2 == 0) {
                p = 2 * p;
                if (p > 9) {
                    p = p - 9;
                }
            }
            checksum += p;
        }
        int control = checksum%10;
        if (control == 0) {
            res = true;
        }
        return res;
    }
}
