import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Lexicon {

    /**
     * Путь к файлу с выходными данными
     */
    private static final String outputFilePath = "d:/lexicon.txt";

    public static void main(String[] args) throws IOException {
        List<String> inputTextStrLit = readFile(args[0]);
        Map<String, Integer> updateText = processLexicon(inputTextStrLit);
        writeLexiconResultFile(outputFilePath, updateText);
        System.out.println("Done");
    }

    /**
     * Чтение данных из файла
     *
     * @param filePath - путь к файлу
     * @return - список строк файла
     * @throws IOException
     */
    public static List<String> readFile(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        // Чтение из файла и формирование списка строк
        Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(result::add);
        return result;
    }

    /**
     * Запись результатов в файл
     *
     * @param filePath - путь к файлу
     * @param result   - статистика
     * @throws IOException
     */
    public static void writeLexiconResultFile(String filePath, Map<String, Integer> result) throws IOException {

        File outputFile = new File(filePath);
        outputFile.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }

    /**
     * Формирование статистики использования слов в списке строк
     *
     * @param text - список строк
     * @return - статистика использования слов
     * @throws IOException
     */
    public static Map<String, Integer> processLexicon(List<String> text) throws IOException {
        List<String> modifyText = new ArrayList<>();
        Map<String, Integer> result = new TreeMap<String, Integer>();
        // Создание списка строк без знаков пунктуации и в нижнем регистре
        for (String currentStr : text) {
            if (!currentStr.isEmpty()) {
                modifyText.add(currentStr.
                        replaceAll("\\p{Punct}", " ").
                        replaceAll("[\\s]{2,}", " ").toLowerCase());
            }

        }
        // Подсчет статистики с учетом модификации исходных строк
        for (String currentStr : modifyText) {
            String[] words = currentStr.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() != 0) {
                    if (result.containsKey(words[i])) {
                        result.put(words[i], result.get(words[i]) + 1);
                    } else {
                        result.put(words[i], 1);
                    }
                }
            }

        }
        return result;
    }
}
