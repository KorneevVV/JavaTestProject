import java.util.Calendar;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(Calendar.getInstance().getTimeInMillis()); //передача в конструктор Random, текущее время в милисекундах, позволяет добиться уникальности имен
        IntStream.range(0, 10).forEach(i -> System.out.println(random.ints(48, 122).filter(y -> (y < 57 || y > 65) && (y < 90 || y > 97)).mapToObj(y -> (char) y).limit(25).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString() + "@mail.ru")); //limit(25) - 25 символов в имени, значение захордкодил
    }
}
