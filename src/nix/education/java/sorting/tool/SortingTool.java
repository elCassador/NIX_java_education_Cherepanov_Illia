package nix.education.java.sorting.tool;

//javac -sourcepath ./src -d bin src/nix/education/java/sorting/tool/SortingTool.java


public class SortingTool {

    public static void main(String[] args) {

        ArgumentAnalyze argumentAnalyze = new ArgumentAnalyze();
        argumentAnalyze.setArgument(args);
        argumentAnalyze.defineDataType();
    }
}
