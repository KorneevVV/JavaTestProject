/**
 * Created by kracoz on 17.04.2017.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Есть строка: “Текущая дата 01.04.2015”
 Нужно преобразовать строку в: “Дата покупки 05.04.15” (т.е. к текущей дате
 прибавить 4 дня)
 Реализовать в виде функции. Входные параметры: строка и на сколько дней
 увеличить дату.
 Выполнить по желанию: учесть случай, что текст в строке может быть любой.

 */

public class AdderFewDays {


    public static void main(String[] args) {
        String firstText = "Текущая дата 01.04.2015";
        System.out.println(addDays(firstText,4));
    }

    public static String addDays(String text, int counDays){
        Pattern pattern = Pattern.compile("\\d{1,2}([-. /])\\d{1,2}\\1\\d{2,4}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {

            String s = matcher.group();
            String[] textDate = s.split("\\.");

            int year =  Integer.parseInt(textDate[2]);
            int month =  Integer.parseInt(textDate[1])-1;
            int day =  Integer.parseInt(textDate[0]);

            Calendar date = new GregorianCalendar();
            date.set(Calendar.MONTH, month);
            date.set(Calendar.DATE, day);
            date.set(Calendar.YEAR, year);

            //Прибавим к дате пару дней;
            date.add(Calendar.DATE, counDays);
            //Новая дата
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            return "Дата покупки " + format.format(date.getTime());
        } else {
        }return "Дата не обнаружена.";
    }
}
