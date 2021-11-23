package nix.education.java.dinner.party;
import java.util.Map;
import java.util.Scanner;

public class LuckyFeature {

    DinnerPartyConstants dinnerPartyConstants = new DinnerPartyConstants();
    Scanner scanner = new Scanner(System.in);

    public String getLucky(Map<String, String> MAP_OF_MEMBERS) {
        final int ANSWER_INDEX = (int) (Math.random() * MAP_OF_MEMBERS.size());
        int counter = 0;
        String ANSWER = dinnerPartyConstants.NO_LUCKY;
        System.out.println("Do you want to use the \"Who is lucky?\" feature? Write Yes/No:");
        String USER_INPUT = scanner.next();
        if (USER_INPUT.equals("Yes")) {
            for (Map.Entry<String, String> item : MAP_OF_MEMBERS.entrySet()) {

                if (counter == ANSWER_INDEX) {
                    ANSWER = item.getKey() + " is the lucky one!";
                } else {
                    counter++;
                }

            }
        }
        return ANSWER;
    }
}
