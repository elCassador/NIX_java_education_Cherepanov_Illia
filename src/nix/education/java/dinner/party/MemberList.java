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
        int total_amount = scanner.nextInt();
        equally_divided_amount = total_amount / number_of_members;
        for(Map.Entry<String, String> item : map_of_members.entrySet()){

            map_of_members.replace(item.getKey(), String.format("%.2f", equally_divided_amount));

        }
    }

    public void getListOfMembers(String lucky_feature_output) {

        System.out.println(lucky_feature_output);

        String[] temp = lucky_feature_output.split(" ");
        String name_of_lucky = temp[0];

        if (name_of_lucky.equals(dinnerPartyConstants.NO_LUCKY)) {
            for (Map.Entry<String, String> item : map_of_members.entrySet()) {

                System.out.printf("Guest: %s  Pay: %s \n", item.getKey(), item.getValue());

            }
        }
        else {

            float additional_amount = equally_divided_amount /(number_of_members - 1);


            for (Map.Entry<String, String> item : map_of_members.entrySet()) {

                map_of_members.replace(item.getKey(), String.valueOf(equally_divided_amount + additional_amount));

                if (item.getKey().equals(name_of_lucky)) {
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
