package testcase1;

import InputData;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Starter {

    /**
     * Начала выходной строки
     */
    private static String outputStartString = "Дата покупки";

    public static void main(String[] args) throws IOException, ParseException {
        InputData inputData = null;
        while (true) {
            inputData = initInputData();
            System.out.println(addDays(inputData));
        }
    }

    /**
     * Инициализация входных данных из консоли
     *
     * @return - модель входных данных из консоли
     */
    public static InputData initInputData() {
        InputData result = new InputData();
        Scanner input = new Scanner(System.in); // Объявляем Scanner
        while (result.getText() == null) {
            System.out.println("Введите строку с датой");
            String text = input.nextLine();
            if (checkInputText(text)) {
                result.setText(text);
            } else {
                System.out.println("Повторите попытку");
            }
        }
        while (result.getIncreaseDateCount() == null) {
            System.out.println("Введите на сколько дней следует увеличить дату");
            String countDateString = input.nextLine();
            if (checkInputIncDay(countDateString)) {
                result.setIncreaseDateCount(Integer.parseInt(countDateString));
            } else {
                System.out.println("Повторите попытку");
            }
        }
        return result;
    }

    /**
     * Прибавление дней
     *
     * @param data - модель входных данных
     * @return - строка с прибавленным количеством дней
     */
    public static String addDays(InputData data) throws ParseException {
        String result = null;
        Pattern pattern = Pattern.compile("\\d{1,2}([-. /])\\d{1,2}\\1\\d{2,4}");
        Matcher matcher = pattern.matcher(data.getText());
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        if (matcher.find()) {
            String s = matcher.group();
            Date textDate= format.parse(s);

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(textDate);
            // прибавляем n-дней к установленной дате
            calendar.add(Calendar.DATE, data.getIncreaseDateCount());
            Date newDate = calendar.getTime(); // получаем измененную дату
            //Новый формат даты
            DateFormat newFormat = new SimpleDateFormat("dd.MM.yy");
            result = outputStartString + " " + newFormat.format(newDate.getTime());
        }
        return result;
    }

    /**
     * Проверка входной строки на наличие даты в формате dd.mm.yyyy
     *
     * @param text - строка
     * @return - true - если строка содержит в себе дату, иначе - false
     */
    public static boolean checkInputText(String text) {
        boolean result = false;
        String pattern = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}";

        //--*- get dateString -*--
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        if (matcher.find()) {
            result = true;
        } else {
            System.out.println("Введенный текст не содержит дату в формате dd.mm.yyyy");
        }
        return result;
    }

    /**
     * Проверка входной строки на соответстиве числовому полю
     *
     * @param text - строка
     * @return - true - если строка является числом, иначе - false
     */
    public static boolean checkInputIncDay(String text) {
        boolean result = false;
        try {
            int incDays = Integer.parseInt(text);
            result = true;
        } catch (NumberFormatException e){
            System.out.println("Введенный строка содержит не числовые символы");
        }
        return result;
    }


}
