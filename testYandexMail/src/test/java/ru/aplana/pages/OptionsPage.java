package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by AlisaHP on 03.05.2017.
 */
public class OptionsPage extends PageObject {
    @FindBy(xpath = "//input[@name='from_name']")
    private WebElementFacade enterName;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElementFacade enterPodp;

    @FindBy(xpath = "//span[@class='ui-button-text']//span[@class='_nb-button-content']//span[.='Добавить подпись']")
    private WebElementFacade addPodpBtn;

    @FindBy(xpath = "//svg[@class='svgicon svgicon-boot--Mail_rus']")
    private WebElementFacade closeBtn;
    @FindBy(xpath = "//a[@class='b-mail-dropdown__item__content ']")
    private WebElementFacade exitBtn;

    @FindBy(xpath = "//div[@class='mail-User-Name']")
    private WebElementFacade userBtn;

    public void enterUserName(String name){
        enterName.clear();
        enterName.sendKeys(name);
    }
    public void addPodpis()  {
        Calendar Current_Calendar = Calendar.getInstance();
        Date Current_Date = Current_Calendar.getTime();

        enterPodp.sendKeys(Current_Date.toString());
        addPodpBtn.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userBtn.click();
        exitBtn.click();
        closeBtn.click();
    }
}
