package nix.education.java.sorting.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//java -classpath ./bin nix.education.java.sorting.tool.SortingTool -dataType word


public class WordsDataSorting {

    private ArrayList<String> word_data_storage = new ArrayList<String>();
    private ArrayList<String> max_word_data = new ArrayList<String>();

    public void setWordData(String data) {
        word_data_storage.add(data);
    }

    final public void getWordsSize() {
        System.out.println("Total words: " + word_data_storage.size());
    }

    final public void getWordsDataSizeInFile(String output_file) {
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            writer.println("Total numbers: " + word_data_storage.size());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    final public void getGreatestWordData() {
        int max_length = 0;
        for (String word : word_data_storage) {
            if (max_length < word.length()) {
                max_word_data.clear();
                max_word_data.add(word);
                max_length = word.length();
            } else if (max_length == word.length()) {
                max_word_data.add(word);
            }
        }
        Collections.sort(max_word_data);
    }

    final public int getNumberOfOccurrences(String line_data) {
        int counter = 0;
        for (String data : word_data_storage) {
            if (data.equals(line_data)) {
                counter++;
            }
        }

        return counter;
    }

    public void sortWordsNatural() {
        Collections.sort(word_data_storage);
        Collections.reverse(word_data_storage);
        System.out.print("Sorted data: ");
        for (String element : word_data_storage) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void sortWordsNaturalInFile(String output_file) {
        Collections.sort(word_data_storage);
        Collections.reverse(word_data_storage);
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")){
            writer.print("Sorted data: ");
            for (String element : word_data_storage) {
                writer.print(element + " ");
            }
            writer.println();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    public void sortWordsByCount() {

        TreeMap<String, Integer> mapOfLines = new TreeMap<>();
        LinkedHashMap<String, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (String element : word_data_storage) {
            mapOfLines.put(element, getNumberOfOccurrences(element));
        }

        mapOfLines.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
            System.out.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / word_data_storage.size());
            System.out.println();
        }
    }

    public void sortWordsByCountInFile(String output_file) {

        TreeMap<String, Integer> mapOfLongs = new TreeMap<>();
        LinkedHashMap<String, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (String element : word_data_storage) {
            mapOfLongs.put(element, getNumberOfOccurrences(element));
        }

        mapOfLongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            for (Map.Entry<String, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
                writer.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / word_data_storage.size());
                writer.println();
            }
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }
}
