/**
 * Created by kracoz on 18.04.2017.
 */

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 *  Создать файл input.txt и поместить в него фрагмент английского текста. Создать
 класс Lexicon.java так, что при выполнении команды java Lexicon input.txt в том же
 каталоге появляется файл lexicon.txt со статистикой использованных слов. Пример:
 A - 50
 The - 100
 Abbat - 1
 boy - 3
 boys - 4
 (Слова отсортировать в алфавитном порядке). По желанию учесть формы
 множественного числа (т.е. в примере выше д.б. boy - 7)
 */
public class Lexicon {

    public static void main(String[] args) throws IOException {
        Lexicon.lexicon(args[0]);
    }

    public static boolean isLetter(char c) {
        if ( (c >= 97) && (c <= 122) ) return true; // a - z
        if ( (c >= 65) && (c <= 90) )  return true; // A - Z
        return false;
    }

    public static char toLower(char c) {
        if ( (c >= 65) && (c <= 90) )  return (char)(c + 32); // A-Z to a-z
        return c;
    }

    public static void lexicon(String input) throws IOException {
        File inputFile = new File(Paths.get("").toAbsolutePath().toString() + "\\" + input);
        File  outputFile = new File(Paths.get("").toAbsolutePath().toString() + "\\lexicon.txt");
        outputFile.createNewFile();
        Map<String,Integer> result = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        StringBuffer sb = new StringBuffer("");
        String line;
        String NL = System.getProperty("line.separator");
        while ( (line = reader.readLine()) != null) {
            sb.append(line + NL);
        }
        reader.close();

        String text = sb.toString();
        int words = 0;

        StringBuffer word = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ( isLetter(c) ) {
                word.append(toLower(c));
            }
            else {
                if ( word.length() != 0 ) {
                    words++;
                    if (result.containsKey(word.toString())) {
                        result.put(word.toString(), result.get(word.toString()) + 1);
                    }
                    else {
                        result.put(word.toString(), 1);
                    }
                }
                word.delete(0, word.length());
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        for (Map.Entry<String, Integer> entry: result.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }
}
