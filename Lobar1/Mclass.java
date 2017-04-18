public class Mclass {
    public static void main(String[] args)  {
        System.out.println(dayIncrement("Текущая дата 01.04.2015",4));
    }
    private static String dayIncrement (String in, int d){
        //вытаскиваем месяц, число, год из входной строки in
        String inDay    = in.substring((in.length()-10), (in.length()-8));
        String inMonth  = in.substring((in.length()-8), (in.length()-5));
        String inYear   = in.substring(in.length()-5);
        //к входной дате прибавляем необходимое количесвто дней
        int days = Integer.parseInt(inDay) + d;
        String day = Integer.toString(days);
        //добавляем "0" если необходимо
        if (days < 10){
            day = "0"+day;
        }
        return "Дата покупки " + day + inMonth + inYear;
    }
}