import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mclass {

    public static void main(String[] args) throws ParseException {
        String inputDate = "Текущая дата 01.04.2015";
        System.out.println(dayIncrement(inputDate,33));
    }

    private static String dayIncrement(String in, int d) throws ParseException {
        String inputDate = in.replaceAll("[a-zA-Zа-яА-Я]+", "");
        //достали дату из входящей строки
        String outputDate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        //создали формат даты
        Date date = sdf.parse(inputDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //присвоили календарю входящую дату
        int year  = cal.get(Calendar.YEAR);
        int month = (cal.get(Calendar.MONTH)+1);
        //месяцы от 0 идут
        int day   = cal.get(Calendar.DAY_OF_MONTH);
        outputDate = ((day+d)+"."+month+"."+year);
        //увеличили дату на необходимое количество дней
        date = sdf.parse(outputDate);
        //присвоили новую дату
        outputDate = sdf.format(date);
        //отформатировали новую дату
        return "Дата покупки " +outputDate;
    }
}
