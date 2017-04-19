import static junit.framework.Assert.assertEquals;

/**
 * Created by Влад on 19.04.2017.
 */
public class MainTest {
    @org.junit.Test
    public void recognitionDateAndModificationString() throws Exception {
        assertEquals("Date at the beginning", Main.recognitionDateAndModificationString("01.04.2016 Текущая дата",4), "Дата покупки 05.04.16");
        assertEquals("Date at the middle", Main.recognitionDateAndModificationString("Текущая дата 01.04.2016 г.",4), "Дата покупки 05.04.16");
        assertEquals("Date at the end", Main.recognitionDateAndModificationString("Текущая дата 01.04.2016",4), "Дата покупки 05.04.16");
        assertEquals("Only date", Main.recognitionDateAndModificationString("01.04.2016",4), "Дата покупки 05.04.16");
        assertEquals("Without date", Main.recognitionDateAndModificationString("Нет даты",4), "The expression does not contain the format date dd.MM.yyyy");
    }
}
