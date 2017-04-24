/**
 * Created by kracoz on 18.04.2017.
 */

import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Lexicon {

    public static void main(String[] args) throws IOException {
        String text = readTextFile(args[0]);
        Map<String,Integer> result = lexicon(text);
        writeLexiconResultFile(result);
        int countParagraph = countParagraph(args[0]);
        writeCountParagraphResultFile(countParagraph);
    }

    public static String readTextFile(String file) throws IOException {

        File inputFile = new File(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        StringBuffer sb = new StringBuffer("");
        String line;
        String NL = System.getProperty("line.separator");
        while ( (line = reader.readLine()) != null) {
            sb.append(line + NL);
        }
        reader.close();

        return sb.toString();
    }

    public static Map<String,Integer> lexicon(String text) throws IOException {

        Map<String,Integer> result = new TreeMap<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ( isLetter(c) ) {
                word.append(String.valueOf(c).toLowerCase());// Не очень хороший вариант создавать новые строки, с char лучше
            }
            else {
                if ( word.length() != 0 ) {
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
        return result;
    }

    public static int countParagraph(String file) throws IOException {
        int count = 0;
        File inputFile = new File(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
        String text;

        while ((text = reader.readLine()) != null) {
            if (!text.equals("")) {
                int c = text.charAt(0);
                count += ( c == 13) ? 1:0;
            } else {

                count++;
                if (reader.ready()) {
                    while ((reader.readLine()).equals("")){
                        if(!reader.ready()) {
                            count--;
                            break;
                        }
                    }
                }else count--;

            }
        }
        reader.close();
        if(count >= 0 ) count++;
        return count;
    }


    public static void writeLexiconResultFile(Map<String,Integer> result) throws IOException {

        File  outputFile = new File("lexicon.txt");
        outputFile.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        for (Map.Entry<String, Integer> entry: result.entrySet()) {
            bw.write(entry.getKey() + " - " + entry.getValue());
            bw.newLine();
        }
        bw.close();
    }
    public static void writeCountParagraphResultFile(int result) throws IOException {

        File  outputFile = new File("countParagraph.txt");
        outputFile.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        bw.write("Колличество абзацев " + result);
        bw.newLine();
        bw.close();
    }

    private static boolean isLetter(char c) {
        if ( (c >= 97) && (c <= 122) ) return true; // a - z
        if ( (c >= 65) && (c <= 90) )  return true; // A - Z
        return false;
    }

  /*  private static char toLower(char c) {
        if ( (c >= 65) && (c <= 90) )  return (char)(c + 32); // A-Z to a-z
        return c;
    }*/

}
