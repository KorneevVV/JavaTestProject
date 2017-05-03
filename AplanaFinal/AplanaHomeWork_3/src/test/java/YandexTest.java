import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class YandexTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private User user;
    private String userName;
    private String userPassword;

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        user = new User("DmitriyZotovTest", "DmitriyZotovTest007");
        userName = user.getUserName();
        userPassword = user.getUserPassword();
        driver = new ChromeDriver();
        baseUrl = "https://yandex.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMail() throws Exception {

        driver.get(baseUrl + "");
        driver.findElement(By.xpath("//div//a[@href='https://mail.yandex.ru']")).click();
        driver.findElement(By.xpath(".//input[@name='login']")).clear();
        driver.findElement(By.xpath(".//input[@name='login']")).sendKeys(userName);
        driver.findElement(By.xpath(".//input[@name='passwd']")).sendKeys(userPassword, Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mail-ComposeButton-Wrap']//a[@href='#compose']")));
        driver.findElement(By.xpath("//div[@class='mail-ComposeButton-Wrap']//a[@href='#compose']")).click();
        driver.findElement(By.xpath("//div[@name='to']")).sendKeys("DmitriyZotovTest@yandex.ru");
        driver.findElement(By.xpath("//input[@name='subj']")).sendKeys("Test");
        driver.findElement(By.xpath(".//*[@id='cke_1_contents']/div")).sendKeys("Hello from test");
        driver.findElement(By.id("//button[@type='submit']")).click();
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
