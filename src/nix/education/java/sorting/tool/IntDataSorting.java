package nix.education.java.sorting.tool;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//java -classpath ./bin nix.education.java.sorting.tool.SortingTool -dataType long

public class IntDataSorting {

    private ArrayList<Long> int_data_storage = new ArrayList<Long>();
    public Long max_int_data;

    public void setIntData(Long data) {
        int_data_storage.add(data);
    }

    final public void getIntDataSize() {
        System.out.println("Total numbers: " + int_data_storage.size());
    }

    final public void getIntDataSizeInFile(String output_file) {
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            writer.println("Total numbers: " + int_data_storage.size());
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    protected Long getGreatestIntData() {
        Collections.sort(int_data_storage);
        Collections.reverse(int_data_storage);
        max_int_data = int_data_storage.get(0);
        return int_data_storage.get(0);
    }

    final public int getNumberOfOccurrences(Long int_data) {
        int counter = 0;
        for (Long data : int_data_storage) {
            if (data.equals(int_data)) {
                counter++;
            }
        }

        return counter;
    }

    public void sortIntNatural() {
        Collections.sort(int_data_storage);
        Collections.reverse(int_data_storage);
        System.out.print("Sorted data: ");
        for (Long element : int_data_storage) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void sortIntNaturalInFile(String output_file) {
        Collections.sort(int_data_storage);
        Collections.reverse(int_data_storage);
        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            writer.print("Sorted data: ");
            for (Long element : int_data_storage) {
                writer.print(element + " ");
            }
            writer.println();
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

    public void sortIntByCount() {

        TreeMap<Long, Integer> mapOfLongs = new TreeMap<>();
        LinkedHashMap<Long, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (Long element : int_data_storage) {
            mapOfLongs.put(element, getNumberOfOccurrences(element));
        }

        mapOfLongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        for (Map.Entry<Long, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
            System.out.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / int_data_storage.size());
            System.out.println();
        }
    }

    public void sortIntByCountInFile(String output_file) {

        TreeMap<Long, Integer> mapOfLongs = new TreeMap<>();
        LinkedHashMap<Long, Integer> uniqMapOfLinesSorted = new LinkedHashMap<>();
        for (Long element : int_data_storage) {
            mapOfLongs.put(element, getNumberOfOccurrences(element));
        }

        mapOfLongs.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> uniqMapOfLinesSorted.put(x.getKey(), x.getValue()));

        try (PrintWriter writer = new PrintWriter ("C:\\Users\\angry\\IdeaProjects\\java_NIX\\src\\nix\\education\\java\\sorting\\tool\\" + output_file, "UTF-8")) {
            for (Map.Entry<Long, Integer> entry : uniqMapOfLinesSorted.entrySet()) {
                writer.printf("%s                   : %d time(s), %d%%", entry.getKey(), entry.getValue(), entry.getValue() * 100 / int_data_storage.size());
                writer.println();
            }
            writer.close();
        }
        catch(IOException ex) {
            System.out.println("Can't create " + output_file + " file");
        }
    }

}