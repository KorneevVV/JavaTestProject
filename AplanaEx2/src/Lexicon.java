import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


class Parser {
    private String fileName;
    private String input_text;
    private int val = 1;
    private Map<String, Integer> words;
    private ArrayList<String> elements;
    private File file;
    private FileWriter fw;

    public Parser(String fileN) throws IOException {
        this.fileName = fileN;
        //Существует ли файл
        exists(fileName);
        elements = new ArrayList<>();
        //Преобразуем текст в файле в строку
        fileToString(fileN);
        //Разделяем строку на слова и заполяем словами массив-список
        SplitAndList(input_text);
        file = new File("lexicon.txt");
        fw = new FileWriter(file);
        words = new TreeMap<>();

    }

    //Проверка на существование файла
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    //Перевод текстового файла в строку
    private void fileToString(String fn)
    {
        BufferedReader br = null;
        FileReader fr = null;
        input_text="";
        try {

            fr = new FileReader(fn);
            br = new BufferedReader(fr);

            String s;

            br = new BufferedReader(new FileReader(fn));

            while ((s = br.readLine()) != null) {
                input_text+=s+".";
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    //Разбиение на слова и занесение в массив
    private void SplitAndList(String it)
    {

        for(String s:it.split("[.,:;!?»«() ]+"))
            elements.add(s);
    }

    //Подсчет слов и создание файла со статистикой использованных слов
    public void CountWords()
    {
        for(String w:elements)
        {
            w=w.replaceAll("[0-9]+","");
            w=w.toLowerCase();
            if (words.containsKey(w))
            {
                int value = words.get(w);
                value++;
                words.put(w,value);
            } else if(!w.equals("")) words.put(w,val);
        }

        try {
            //fw = new FileWriter(file,true);
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                fw.write(key + " - " + value + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

public class Lexicon {
    public static void main(String[] args) throws IOException {
        Parser par = new Parser("input.txt");
        par.CountWords();


    }
}