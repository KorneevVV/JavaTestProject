import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class VKLoginSearch {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://vk.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVKLoginSearch() throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, 3);
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//input[@id='index_email']")).clear();
    driver.findElement(By.xpath("//input[@id='index_email']")).sendKeys("89169577765");
    driver.findElement(By.xpath("//input[@id='index_pass']")).clear();
    driver.findElement(By.xpath("//input[@id='index_pass']")).sendKeys("Сложныйпароль");
    driver.findElement(By.xpath("//button[@id='index_login_button']")).click();
    driver.findElement(By.xpath("//input[@id='ts_input'] ")).click();
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='ts_input']"))));
    driver.findElement(By.xpath("//input[@id='ts_input']")).sendKeys("Корнеев Влад");
    driver.findElement(By.xpath("//span[contains(.,'Показать все результаты')]")).click();
    driver.findElement(By.xpath("//a[@class='ui_rmenu_item _ui_item_people search_menu_people']")).click();
    driver.findElement(By.xpath("//div[@id=\"cCountry\"]/descendant::input[@class=\"selector_input\"]")).click();
    driver.findElement(By.xpath("//li[contains(.,\"Россия\")]")).click();
    driver.findElement(By.xpath("//div[@id=\"cCity\"]/descendant::input[@class=\"selector_input\"]")).click();
    driver.findElement(By.xpath("//li[contains(.,\"Москва\")]")).click();
    driver.findElement(By.xpath("//div[@id=\"results\"]/div[1]"));
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
