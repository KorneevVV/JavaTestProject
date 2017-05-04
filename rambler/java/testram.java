import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class testram {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.rambler.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRam() throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 3);
    driver.get(baseUrl + "/");
    assertEquals("Рамблер - медийный портал", driver.getTitle());
    driver.findElement(By.xpath("//a[@class='b-informers__item b-informers__item_mail']"))).click();
    driver.findElement(By.xpath("//input[@name='login']")).clear();
    driver.findElement(By.xpath("//input[@name='login']")).sendKeys("testramjav");
    driver.findElement(By.xpath("//input[@name='login']")).clear();
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("testramjav");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("", driver.getTitle());
    assertEquals("Рамблер/почта – надежная и бесплатная электронная почта, создать электронную почту с защитой от спама и вирусов", driver.getTitle());
    driver.findElement(By.xpath("//a[@data-left-menu='compose open']")).click();
    driver.findElement(By.xpath("//input[@id='receivers']")).clear();
    driver.findElement(By.xpath("//input[@id='receivers']")).sendKeys("vo1k@list.ru");
    driver.findElement(By.xpath("//input[@id='subject']")).clear();
    driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("test");
	getDriver().switchTo().frame("editor_ifr");
    driver.findElement(By.xpath("//body[@data-id='editor']")).clear();
    driver.findElement(By.xpath("//body[@data-id='editor']")).sendKeys("test");
	getDriver().switchTo().defaultContent();
    driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
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
