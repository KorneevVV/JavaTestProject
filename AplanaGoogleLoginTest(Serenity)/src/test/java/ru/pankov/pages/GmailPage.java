package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kracoz on 03.05.2017.
 */
public class GmailPage extends PageObject{

    @FindBy(xpath = "(//div[.='НАПИСАТЬ'])[3]")
    private WebElementFacade writeEmail;

    @FindBy(xpath = "//*[@aria-label='Кому']")
    private WebElementFacade address;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElementFacade subject;

    @FindBy(xpath = "//div[@aria-label='Тело письма']")
    private WebElementFacade textEmail;

    @FindBy(xpath = "(//div[.='Отправить'])[2]")
    private WebElementFacade sendEmail;


    @FindBy(xpath = "(//div[@aria-label='Настройки']|//*[@id=':28']|//div[contains(@class,'T-I J-J5-Ji ash T-I-ax7 L3')]")
    private WebElementFacade clickEdit1;
    @FindBy(xpath = "(//*[@id='ms'][.='Настройки']")
    private WebElementFacade clickEditInto;

    public void clickEdit1(){
       WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Настройки']|//*[@id=':28']|//div[contains(@class,'T-I J-J5-Ji ash T-I-ax7 L3')]")));
        this.clickEdit1.click();
    }

    public void clickEditInto(){
        this.clickEditInto.click();
    }
    public void writeEmail() {
        this.writeEmail.click();
    }
    public void writeAddress(String address) {
        this.address.clear();
        this.address.sendKeys(address);
    }
    public void writeTextEmail(String textEmail) {
        this.textEmail.click();
        String signature = this.textEmail.getText();
        this.textEmail.clear();
        this.textEmail.sendKeys(textEmail + "\n" + signature);
    }
    public void writeSubject(String subj){
        this.subject.click();
        this.subject.clear();
        this.subject.sendKeys(subj);

    }

    public void sendEmail() {
        this.sendEmail.click();
    }

}
