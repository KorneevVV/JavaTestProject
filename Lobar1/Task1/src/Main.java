import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Влад on 17.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        modificationTheDateInString();
    }
    
    private static void modificationTheDateInString() {
        String expression = null;
        long daysToAdd = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)))) {
            expression = readStringFromConsole(bufferedReader);
            daysToAdd = readDaysFromConsole(bufferedReader);
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(recognitionDateAndModificationString(expression, daysToAdd));
    }
    
    private static String readStringFromConsole(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter expression:");
        return bufferedReader.readLine();
    }
    
    private static long readDaysFromConsole(BufferedReader bufferedReader) throws IOException, NumberFormatException {
        System.out.println("Enter days to add:");
        return Long.parseLong(bufferedReader.readLine());
    }
    
    static String recognitionDateAndModificationString(String expression, long daysToAdd) {
        String dateString = findDate(expression);
        String resultModification;
        if (dateString != null) {
            LocalDate date = recognitionDate(dateString);
            LocalDate newDate = modificationDate(date, daysToAdd);
            String newDateString = newDate.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
            resultModification = "Дата покупки " + newDateString;
        } else {
            resultModification = "The expression does not contain the format date dd.MM.yyyy";
        }
        return resultModification;
    }
    
    private static String findDate(String expression) {
        String result = null;
        Pattern pattern = Pattern.compile("(?:(1[0-2]|0[1-9]).(3[01]|[12][0-9]|0[1-9])|(3[01]|[12][0-9]|0[1-9])." +
                "(1[0-2]|0[1-9])).[0-9]{4}");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }
    
    private static LocalDate modificationDate(LocalDate date, long daysToAdd) {
        return date.plusDays(daysToAdd);
    }
    
    private static LocalDate recognitionDate(String dateString) {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateString, formatDate);
    }
}
