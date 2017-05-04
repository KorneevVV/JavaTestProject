import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomMailGeneratorStarter {

    /**
     * Длина почты до @...
     */
    private static final long MAX_MAIL_SIZE = 7;
    private static final String postfix = "yam.ru";

    public static void main(String[] args) {
        System.out.println(generateRandomMail(MAX_MAIL_SIZE, postfix));
    }

    /**
     * Метод генерациии случайной почты
     *
     * @param mailSize - Длинна почты до @...
     * @param postfix - постфикс почты (то что после @)
     * @return - строка, которая содержит случайную почту
     */
    private static String generateRandomMail(final Long mailSize, final String postfix) {
        Random random = new Random(new Date().getTime());
        return random.ints(48, 122).filter(y -> (y < 57 || y > 65) && (y < 90 || y > 97)).mapToObj(y -> (char) y).limit(mailSize).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString() + "@"+postfix;
    }
}
