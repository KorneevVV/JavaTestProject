package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class YandexMailPage extends PageObject {

    private Calendar Current_Calendar = Calendar.getInstance();
    private Date Current_Date = Current_Calendar.getTime();
    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]")
    private WebElementFacade newMailBtn;

    @FindBy(xpath = "//div[@name='to']")
    private WebElementFacade addressField;

    @FindBy(xpath = "//input[@name='subj']")
    private WebElementFacade subjField;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElementFacade textField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade sendMailBtn;
    @FindBy(xpath = "//div[@class='mail-Done-Title js-title-info']")
    private WebElementFacade sendMailStatus;

    @FindBy(xpath = "//a[@class='mail-GhostButton js-header-settings nb']")
    private WebElementFacade optionsBtn;

    @FindBy(xpath = "(//span[@class='settings-popup-menu-item-content'])[1]")
    private WebElementFacade optionsBtnUserData;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElementFacade podpisLabel;


    public void writeNewMail(String address, String sub, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]")));
        newMailBtn.click();
        addressField.clear();
        addressField.type(address);
        subjField.clear();
        subjField.type(sub);
        textField.type(text);
        sendMailBtn.click();
        sendMailStatus.getText();
    }
    public void clickOptions(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='mail-GhostButton js-header-settings nb']")));
        optionsBtn.click();
    }
    public void userDataOptionsClick(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='settings-popup-menu-item-content'])[1]")));
        optionsBtnUserData.click();
    }


    public void checkMailStatus(String status){
        assertTrue(sendMailStatus.getText().equalsIgnoreCase(status));
    }
    public void writeNewMailAndCheckPodpis(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]")));
        newMailBtn.click();
        Date date = Current_Date;
        assertTrue("data ne sovpadaut", podpisLabel.getText().equalsIgnoreCase(date.toString()));
    }
}