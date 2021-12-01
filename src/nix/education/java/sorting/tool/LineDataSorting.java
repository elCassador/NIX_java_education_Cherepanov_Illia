package nix.education.java.sorting.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//java -classpath ./bin nix.education.java.sorting.tool.SortingTool -dataType line

public class LineDataSorting {

    private ArrayList<String> line_data_storage = new ArrayList<String>();
    private ArrayList<String> max_line_data = new ArrayList<String>();

    public void setLineData(String data) {
        line_data_storage.add(data);
    }

    final public void getLineDataSize() {
        System.out.println("Total lines: " + line_data_storage.size());
    }

    final public void getLineDataSizeInFile(String output_file) {
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            writer.println("Total numbers: " + line_data_storage.size());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    final public void getGreatestLineData() {
        int max_length = 0;
        for (String line : line_data_storage) {
            if (max_length < line.length()) {
                max_line_data.clear();
                max_line_data.add(line);
                max_length = line.length();
            }
            else if (max_length == line.length()) {
                max_line_data.add(line);
            }
        }
        Collections.sort(max_line_data);
    }

    final public int getNumberOfOccurrences(String line_data) {
        int counter = 0;
        for (String data : line_data_storage) {
            if (data.equals(line_data)) {
                counter++;
            }
        }

        return counter;
    }

    public void sortLineNatural() {
        Collections.sort(line_data_storage);
        Collections.reverse(line_data_storage);
        System.out.print("Sorted data: ");
        for (String element : line_data_storage) {
            System.out.println(element);
        }
    }

    public void sortLineNaturalInFile(String output_file) {
        Collections.sort(line_data_storage);
        Collections.reverse(line_data_storage);
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            writer.print("Sorted data: ");
            for (String element : line_data_storage) {
                writer.println(element);
            }
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    public void sortLineByCount() {

        TreeMap<String, Integer> mapOfLines = new TreeMap<>();
        LinkedHashMap<String, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (String element : line_data_storage) {
            mapOfLines.put(element, getNumberOfOccurrences(element));
        }

        mapOfLines.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
            System.out.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / line_data_storage.size());
            System.out.println();
        }
    }

    public void sortLineByCountInFile(String output_file) {

        TreeMap<String, Integer> mapOfLongs = new TreeMap<>();
        LinkedHashMap<String, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (String element : line_data_storage) {
            mapOfLongs.put(element, getNumberOfOccurrences(element));
        }

        mapOfLongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            for (Map.Entry<String, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
                writer.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / line_data_storage.size());
                writer.println();
            }
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }
}