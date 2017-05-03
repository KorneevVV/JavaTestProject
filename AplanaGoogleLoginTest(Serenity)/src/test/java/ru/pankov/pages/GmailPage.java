package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

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


    @FindBy(xpath = "(//div[@aria-label='Настройки']")
    private WebElementFacade clickEdit1;
    @FindBy(xpath = "(//*[@id='ms'][.='Настройки']")
    private WebElementFacade clickEditInto;

    public void clickEdit1(){
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
        this.textEmail.clear();
        this.textEmail.sendKeys(textEmail);
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
