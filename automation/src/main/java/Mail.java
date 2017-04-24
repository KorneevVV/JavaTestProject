import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by USERrr on 24.04.2017.
 */
public class Mail {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.yandex.ru/");

        webDriver.findElement(By.xpath("//div//a[@href='https://mail.yandex.ru']")).click();
        System.out.println("Зашли на почту");
        webDriver.findElement(By.xpath(".//input[@name='login']")).sendKeys("DmitriyZotovTest");
        webDriver.findElement(By.xpath(".//input[@name='passwd']")).sendKeys("DmitriyZotovTest007", Keys.RETURN);
        System.out.println("Залогинились");
        //webDriver.wait(5000);
        //*[contains(@class,'mail-ComposeButton')]
        //webDriver.findElement(By.xpath("//div[@class='mail-ComposeButton-Wrap']//a[@href='#compose']")).click();
        webDriver.findElement(By.xpath("*[contains(@class,'mail-ComposeButton')]")).click();
        System.out.println("Кликнули написать письмо");
    }
}
