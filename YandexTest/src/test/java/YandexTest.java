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
    private Mail mail;
    private List<Mail> mails;
    private String[] recipient;
    private String[] subject;
    private String[] text;
    //путь до Адресата и Темы переделать
    private String sub = ".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div";
    private String theme = ".//*[@id='nb-1']/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/label/div[3]/input";

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        user = new User("DmitriyZotovTest", "DmitriyZotovTest007");
        userName = user.getUserName();
        userPassword = user.getUserPassword();
        mail = new Mail("DmitriyZotovTest@yandex.ru",
                "Тест", "Привет из теста");
        mails = new ArrayList<Mail>();
        recipient = new String[10];
        subject = new String[10];
        text = new String[10];
        for (int i = 0; i < 9; i++) {
            mails.add(new Mail("DmitriyZotovTest@yandex.ru",
                    "Тест " + i, "Привет из теста " + i));
            recipient[i] = mails.get(i).getRecipient();
            subject[i] = mails.get(i).getSubject();
            text[i] = mails.get(i).getText();
        }
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
        driver.findElement(By.xpath(sub)).sendKeys(recipient[0]);
        driver.findElement(By.xpath(theme)).sendKeys(subject[0]);
        driver.findElement(By.xpath(".//*[@id='cke_1_contents']/div")).sendKeys(text[0]);
        driver.findElement(By.id("nb-16")).click();
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
