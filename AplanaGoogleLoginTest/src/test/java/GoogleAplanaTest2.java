
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAplanaTest2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
public void click (WebElement webElement){
  WebDriverWait wait = new WebDriverWait(driver,30);
  wait.until(ExpectedConditions.visibilityOf(webElement));

}
  @Test
  public void testGoogleAplanaTest2() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Почта")).click();
    driver.findElement(By.xpath("//input[@id='Email']|//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@id='Email']|//input[@type='email']")).sendKeys("pankovtestaplana@gmail.com");

    click(driver.findElement(By.xpath("//*[@id='next']|//*[@id='identifierNext']")));
    driver.findElement(By.xpath("//*[@id='next']|//*[@id='identifierNext']")).click();

    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver d) {
        try {
          return d.findElement(By.xpath("//*[@id='Passwd']|//input[@type='password']")).isDisplayed();
        }
        catch (NoSuchElementException e) {
          return false;
        }
      }
    });
   // click( driver.findElement(By.xpath("//*[@id='Passwd']|//input[@type='password']")));

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@id='Passwd']|//input[@type='password']")).click();
    driver.findElement(By.xpath("//*[@id='Passwd']|//input[@type='password']")).clear();
    driver.findElement(By.xpath("//*[@id='Passwd']|//input[@type='password']")).sendKeys("kracoz13");
    driver.findElement(By.xpath("//*[@id='signIn']|//*[@id='passwordNext']")).click();

    click(driver.findElement(By.xpath("(//div[.='НАПИСАТЬ'])[3]")));
    driver.findElement(By.xpath("(//div[.='НАПИСАТЬ'])[3]")).click();


    driver.findElement(By.xpath("//*[@aria-label='Кому']")).clear();
    driver.findElement(By.xpath("//*[@aria-label='Кому']")).sendKeys("pankovtestaplana@gmail.com");
    driver.findElement(By.xpath("//*[@aria-label='Кому']")).click();

    /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver d) {
        try {
          return d.findElement(By.xpath("//input[@name='subjectbox']")).isDisplayed();
        }
        catch (NoSuchElementException e) {
          return false;
        }
      }
    });

    driver.findElement(By.xpath("//input[@name='subjectbox']")).click();
    driver.findElement(By.xpath("//input[@name='subjectbox']")).clear();
    driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("testAplana");*/

    driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).click();
    driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).clear();
    driver.findElement(By.xpath("//div[@aria-label='Тело письма']")).sendKeys("testAplana");

    driver.findElement(By.xpath("(//div[.='Отправить'])[2]")).click();

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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
