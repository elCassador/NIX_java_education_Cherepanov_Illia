package nix.education.java.dinner.party;
import java.util.Map;
import java.util.Scanner;

public class LuckyFeature {

    DinnerPartyConstants dinnerPartyConstants = new DinnerPartyConstants();
    Scanner scanner = new Scanner(System.in);

    public String getLucky(Map<String, String> MAP_OF_MEMBERS) {
        int answer_index = (int) (Math.random() * MAP_OF_MEMBERS.size());
        int counter = 0;
        String answer = dinnerPartyConstants.NO_LUCKY;
        System.out.println("Do you want to use the \"Who is lucky?\" feature? Write Yes/No:");
        String user_input = scanner.next();
        if (user_input.equals("Yes")) {
            for (Map.Entry<String, String> item : MAP_OF_MEMBERS.entrySet()) {

                if (counter == answer_index) {
                    answer = item.getKey() + " is the lucky one!";
                } else {
                    counter++;
                }

            }
        }
        return answer;
    }
}
