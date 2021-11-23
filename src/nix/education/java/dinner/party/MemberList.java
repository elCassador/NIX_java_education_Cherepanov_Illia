package nix.education.java.dinner.party;
import java.util.*;

public class MemberList {

    DinnerPartyConstants dinnerPartyConstants = new DinnerPartyConstants();
    Scanner scanner = new Scanner(System.in);
    public Map<String, String> MAP_OF_MEMBERS = new HashMap<String, String>();
    int NUMBER_OF_MEMBERS;
    float EQUALLY_DIVIDED_AMOUNT;

    public void setMembers() {
        System.out.println("Enter the number of friends joining (including you): ");
        NUMBER_OF_MEMBERS = scanner.nextInt();
        if (checkInput(NUMBER_OF_MEMBERS)) {
            System.out.println("Enter the name of every friend (including you), each on a new line: ");
            for (int i = 0; i < NUMBER_OF_MEMBERS; i++) {
                String GUEST = scanner.next();
                MAP_OF_MEMBERS.put(GUEST, "0");
            }
        }
    }

    public void setTotalAmount() {
        System.out.println("Enter the total amount: ");
        int TOTAL_AMOUNT = scanner.nextInt();
        EQUALLY_DIVIDED_AMOUNT = TOTAL_AMOUNT / NUMBER_OF_MEMBERS;
        for(Map.Entry<String, String> item : MAP_OF_MEMBERS.entrySet()){

            MAP_OF_MEMBERS.replace(item.getKey(), String.format("%.2f", EQUALLY_DIVIDED_AMOUNT));

        }
    }

    public void getListOfMembers(String LUCKY_FEATURE_OUTPUT) {

        System.out.println(LUCKY_FEATURE_OUTPUT);

        String[] temp = LUCKY_FEATURE_OUTPUT.split(" ");
        String NAME_OF_LUCKY = temp[0];

        if (NAME_OF_LUCKY.equals(dinnerPartyConstants.NO_LUCKY)) {
            for (Map.Entry<String, String> item : MAP_OF_MEMBERS.entrySet()) {

                System.out.printf("Guest: %s  Pay: %s \n", item.getKey(), item.getValue());

            }
        }
        else {

            float ADDITIONAL_AMOUNT = EQUALLY_DIVIDED_AMOUNT/(NUMBER_OF_MEMBERS - 1);


            for (Map.Entry<String, String> item : MAP_OF_MEMBERS.entrySet()) {

                MAP_OF_MEMBERS.replace(item.getKey(), String.valueOf(EQUALLY_DIVIDED_AMOUNT + ADDITIONAL_AMOUNT));

                if (item.getKey().equals(NAME_OF_LUCKY)) {
                    MAP_OF_MEMBERS.replace(item.getKey(), "0");
                }

                System.out.printf("Guest: %s  Pay: %s \n", item.getKey(), item.getValue());

            }
        }
    }

    private boolean checkInput(int NUMBER_OF_MEMBERS) {
        if (NUMBER_OF_MEMBERS <= 0) {
            System.out.println(dinnerPartyConstants.INVALID_PARTY_MEMBERS_MESSAGE);
            return false;
        }
        else {
            return true;
        }
    }


}
