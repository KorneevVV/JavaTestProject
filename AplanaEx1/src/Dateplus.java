import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dateplus {

    private static String outputStartString = "Дата покупки";

    public static void main(String[] args) throws ParseException
    {
        String inputDate="Текущая дата 01.04.2015";
        System.out.println(dayplus(inputDate,36));
    }

    private static String dayplus(String id, int d) throws ParseException
    {
        String inputDate = id.replaceAll("[a-zA-Zа-яА-Я]+", "");
        String outputDate;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = simpleDateFormat.parse(inputDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year  = cal.get(Calendar.YEAR);
        int month = (cal.get(Calendar.MONTH)+1);
        int day   = cal.get(Calendar.DAY_OF_MONTH);
        outputDate = ((day+d)+"."+month+"."+year);
        date = simpleDateFormat.parse(outputDate);
        outputDate = simpleDateFormat.format(date);
        return "Дата покупки " +outputDate;
    }
}

