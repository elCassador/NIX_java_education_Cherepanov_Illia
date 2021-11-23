package nix.education.java.dinner.party;

public class DinnerParty {

    public static void main(String[] args) {
        MemberList memberList  = new MemberList();
        LuckyFeature luckyFeature = new LuckyFeature();
        memberList.setMembers();
        memberList.setTotalAmount();
        String LUCKY_FEATURE_OUTPUT = luckyFeature.getLucky(memberList.MAP_OF_MEMBERS);
        memberList.getListOfMembers(LUCKY_FEATURE_OUTPUT);
    }
}
