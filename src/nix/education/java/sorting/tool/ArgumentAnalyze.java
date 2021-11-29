package nix.education.java.sorting.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ArgumentAnalyze {

    private SortingToolConstants sortingToolConstants = new SortingToolConstants();
    private ArrayList<String> input_arguments = new ArrayList<String>();
    private String data_type_key = null;
    private String sort_type_key = null;
    private String input_file = null;
    protected String output_file = null;
    private IntDataSorting intDataSorting = new IntDataSorting();
    private LineDataSorting lineDataSorting = new LineDataSorting();
    private WordsDataSorting wordsDataSorting = new WordsDataSorting();
    private Scanner scanner = new Scanner(System.in);


    public void setArgument(String[] args) {
        for (String arg : args) {
            input_arguments.add(arg);
        }

        for (String arg : args) {
            if (arg.charAt(0) == '-') {
                getKey(arg);
            }
        }

        // if -sortingType is not enter
        if (sort_type_key == null) {
            sort_type_key = sortingToolConstants.NATURAL_SORT;
        }
    }

    private void getKey(String argument) {

        if (argument.equals(sortingToolConstants.INPUT_TYPE)) {
            try {
                data_type_key = input_arguments.get(input_arguments.indexOf(argument) + 1);
            }
            catch (java.lang.IndexOutOfBoundsException e) {
                System.out.println("No data type defined!");
                data_type_key = sortingToolConstants.WRONG;
            }
        }
        else if (argument.equals(sortingToolConstants.SORT_TYPE)) {
            try {
                sort_type_key = input_arguments.get(input_arguments.indexOf(argument) + 1);
            }
            catch (java.lang.IndexOutOfBoundsException e) {
                System.out.println("No sorting type defined!");
                sort_type_key = sortingToolConstants.WRONG;
            }
        }
        else if (argument.equals(sortingToolConstants.INPUT_FILE)) {
            try {
                input_file = input_arguments.get(input_arguments.indexOf(argument) + 1);
            }
            catch (java.lang.IndexOutOfBoundsException e) {

            }
        }
        else if (argument.equals(sortingToolConstants.OUTPUT_FILE)) {
            try {
                output_file = input_arguments.get(input_arguments.indexOf(argument) + 1);
            }
            catch (java.lang.IndexOutOfBoundsException e) {

            }
        }
        else {
            System.out.println("\"" + argument + "\"" + " is not a valid parameter. It will be skipped.");
        }
    }

    public void defineDataType() {
        if (data_type_key.equals(sortingToolConstants.LONG_INPUT) && !sort_type_key.equals(sortingToolConstants.WRONG)) {
            if (input_file == null) {
                sortLongsFromLine();
            }
            else {
                try {
                    sortLongsFromFile();
                }
                catch (Exception e) {
                    System.out.println("Missing input file");
                }
            }
        }
        else if (data_type_key.equals(sortingToolConstants.LINE_INPUT) && !sort_type_key.equals(sortingToolConstants.WRONG)) {
            if (input_file == null) {
                sortLinesFromLine();
            }
            else {
                try {
                    sortLinesFromFile();
                }
                catch (Exception e) {
                    System.out.println("Missing input file");
                }
            }
         }
        else if (data_type_key.equals(sortingToolConstants.WORD_INPUT) && !sort_type_key.equals(sortingToolConstants.WRONG)) {
            if (input_file == null) {
                sortWordsFromLine();
            }
            else {
                try {
                    sortWordsFromFile();
                }
                catch (Exception e) {
                    System.out.println("Missing input file");
                }
            }
        }
        else if (!data_type_key.equals(sortingToolConstants.LONG_INPUT) &&
                !data_type_key.equals(sortingToolConstants.LINE_INPUT) &&
                !data_type_key.equals(sortingToolConstants.WORD_INPUT)){
            System.out.println("No data type defined!");
        }
    }

    private void sortLongsFromLine() {
        String long_data;
        while (scanner.hasNext()) {
            long_data = scanner.next();
            if (long_data.matches("-?\\d+(\\.\\d+)?")) {
                Long l = Long.parseLong(long_data);
                intDataSorting.setIntData(l);
            }
            else {
                System.out.println("\"" + long_data + "\"" + " is not a long. It will be skipped.");
            }
        }
        getSortingLong();
    }

    private void sortLinesFromLine() {
        String line_data;
        while (scanner.hasNext()) {
            line_data = scanner.nextLine();
            lineDataSorting.setLineData(line_data);
        }
        getSortingLine();
    }

    private void sortWordsFromLine() {
        String word_data;
        while (scanner.hasNext()) {
            word_data = scanner.next();
            wordsDataSorting.setWordData(word_data);
        }
        getSortingWord();
    }

    private void sortLongsFromFile() throws Exception {
        Scanner text_scanner = new Scanner(new File("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + input_file));
        String long_data;
        while (text_scanner.hasNext()) {
            long_data = text_scanner.next();
            if (long_data.matches("-?\\d+(\\.\\d+)?")) {
                Long l = Long.parseLong(long_data);
                intDataSorting.setIntData(l);
            }
            else {
                System.out.println("\"" + long_data + "\"" + " is not a long. It will be skipped.");
            }
        }
        getSortingLong();
    }

    private void sortLinesFromFile() throws Exception {
        Scanner text_scanner = new Scanner(new File("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + input_file));
        String line_data;
        while (text_scanner.hasNext()) {
            line_data = text_scanner.nextLine();
            lineDataSorting.setLineData(line_data);
        }
        getSortingLine();
    }

    private void sortWordsFromFile() throws Exception{
        Scanner text_scanner = new Scanner(new File("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + input_file));
        String word_data;
        while (text_scanner.hasNext()) {
            word_data = text_scanner.next();
            wordsDataSorting.setWordData(word_data);
        }
        getSortingWord();
    }

    private void getSortingLong() {
        if (output_file == null) {
            intDataSorting.getIntDataSize();
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                intDataSorting.sortIntNatural();
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                intDataSorting.sortIntByCount();
            }
        }
        else {
            intDataSorting.getIntDataSizeInFile(output_file);
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                intDataSorting.sortIntNaturalInFile(output_file);
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                intDataSorting.sortIntByCountInFile(output_file);
            }
        }
    }

    private void getSortingLine() {
        if (output_file == null) {
            lineDataSorting.getLineDataSize();
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                lineDataSorting.sortLineNatural();
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                lineDataSorting.sortLineByCount();
            }
        }
        else {
            lineDataSorting.getLineDataSizeInFile(output_file);
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                lineDataSorting.sortLineNaturalInFile(output_file);
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                lineDataSorting.sortLineByCountInFile(output_file);
            }
        }
    }

    private void getSortingWord() {
        if (output_file == null) {
            wordsDataSorting.getWordsSize();
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                wordsDataSorting.sortWordsNatural();
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                wordsDataSorting.sortWordsByCount();
            }
        }
        else {
            wordsDataSorting.getWordsDataSizeInFile(output_file);
            if (sort_type_key.equals(sortingToolConstants.NATURAL_SORT)) {
                wordsDataSorting.sortWordsNaturalInFile(output_file);
            } else if (sort_type_key.equals(sortingToolConstants.BY_COUNT)) {
                wordsDataSorting.sortWordsByCountInFile(output_file);
            }
        }
    }

}
