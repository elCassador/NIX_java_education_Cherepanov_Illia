package nix.education.java.dinner.party;
import java.util.*;

public class MemberList {

    DinnerPartyConstants dinnerPartyConstants = new DinnerPartyConstants();
    Scanner scanner = new Scanner(System.in);
    public Map<String, String> map_of_members = new HashMap<String, String>();
    int number_of_members;
    float equally_divided_amount;

    public void setMembers() {
        System.out.println("Enter the number of friends joining (including you): ");
        number_of_members = scanner.nextInt();
        if (checkInput(number_of_members)) {
            System.out.println("Enter the name of every friend (including you), each on a new line: ");
            for (int i = 0; i < number_of_members; i++) {
                String GUEST = scanner.next();
                map_of_members.put(GUEST, "0");
            }
        }
    }

    public void setTotalAmount() {
        System.out.println("Enter the total amount: ");
        final int TOTAL_AMOUNT = scanner.nextInt();
        equally_divided_amount = TOTAL_AMOUNT / number_of_members;
        for(Map.Entry<String, String> item : map_of_members.entrySet()){

            map_of_members.replace(item.getKey(), String.format("%.2f", equally_divided_amount));

        }
    }

    public void getListOfMembers(String LUCKY_FEATURE_OUTPUT) {

        System.out.println(LUCKY_FEATURE_OUTPUT);

        final String[] temp = LUCKY_FEATURE_OUTPUT.split(" ");
        final String NAME_OF_LUCKY = temp[0];

        if (NAME_OF_LUCKY.equals(dinnerPartyConstants.NO_LUCKY)) {
            for (Map.Entry<String, String> item : map_of_members.entrySet()) {

                System.out.printf("Guest: %s  Pay: %s \n", item.getKey(), item.getValue());

            }
        }
        else {

            final float ADDITIONAL_AMOUNT = equally_divided_amount /(number_of_members - 1);


            for (Map.Entry<String, String> item : map_of_members.entrySet()) {

                map_of_members.replace(item.getKey(), String.valueOf(equally_divided_amount + ADDITIONAL_AMOUNT));

                if (item.getKey().equals(NAME_OF_LUCKY)) {
                    map_of_members.replace(item.getKey(), "0");
                }

                System.out.printf("Guest: %s  Pay: %s \n", item.getKey(), item.getValue());

            }
        }
    }

    private boolean checkInput(int num_of_members) {
        if (num_of_members <= 0) {
            System.out.println(dinnerPartyConstants.INVALID_PARTY_MEMBERS_MESSAGE);
            return false;
        }
        else {
            return true;
        }
    }


}
