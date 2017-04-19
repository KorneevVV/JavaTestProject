import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Влад on 17.04.2017.
 */
public class Lexicon {
    private static Map<String, Integer> dictionary = new HashMap<>();
    private static TreeMap<String, Integer> sortedDictionary;
    
    public static void main(String[] args) {
        //start(); // start watch
        readFromFile(args[0]);
        sortedDictionary();
        writeToFile();
        //System.out.println(getElapsedTime()); // stop watch and print result ms
    }
    
    private static void writeToFile() {
        try (OutputStream outputStream = new FileOutputStream(new File(Paths.get("").toAbsolutePath().toString() + "\\src\\lexicon.txt"), true);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Map.Entry<String, Integer> pair : sortedDictionary.entrySet()) {
                bufferedWriter.write(pair.getKey() + " - " + pair.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void sortedDictionary() {
        sortedDictionary = new TreeMap<>(dictionary);
    }
    
    private static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(new File(Paths.get("").toAbsolutePath().toString() + "\\src\\" + fileName)),
                        StandardCharsets.UTF_8)
        )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split("[^a-zA-Z]+");
                addDictionary(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void addDictionary(String[] array) {
        for (String word : array) {
            word = word.toLowerCase();
            if (dictionary.containsKey(word)) {
                int count = dictionary.get(word);
                dictionary.put(word, ++count);
            } else {
                dictionary.put(word, 1);
            }
        }
    }
}
