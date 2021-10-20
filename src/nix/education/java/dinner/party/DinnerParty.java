package nix.education.java.dinner.party;

public class DinnerParty {

    public static void main(String[] args) {
        MemberList memberList  = new MemberList();
        LuckyFeature luckyFeature = new LuckyFeature();
        memberList.setMembers();
        memberList.setTotalAmount();
        String LUCKY_FEATURE_OUTPUT = luckyFeature.getLucky(memberList.map_of_members);
        memberList.getListOfMembers(LUCKY_FEATURE_OUTPUT);
    }
}
