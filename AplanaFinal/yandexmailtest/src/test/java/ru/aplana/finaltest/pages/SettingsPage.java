package ru.aplana.finaltest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage extends PageObject {
    @FindBy(xpath = "//input[@name='from_name']")
    private WebElementFacade enterNameField;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElementFacade enterSignField;

    @FindBy(xpath = "//span[@class='ui-button-text']//span[@class='_nb-button-content']//span[.='Добавить подпись']")
    private WebElementFacade addSignButton;

    @FindBy(xpath = "//svg[@class='svgicon svgicon-boot--Mail_rus']")
    private WebElementFacade closeButton;
    @FindBy(xpath = "//a[@class='b-mail-dropdown__item__content ']")
    private WebElementFacade exitButton;

    @FindBy(xpath = "//div[@class='mail-User-Name']")
    private WebElementFacade userButton;

    @FindBy(xpath = "//a[@class='b-setup-title__link'][1]")
    private WebElementFacade mailButton;


    public void enterUserName(String name) {
        waitint("//input[@name='from_name']");
        enterNameField.clear();
        enterNameField.sendKeys(name);
    }

    public void addSign(String sign) {
        enterSignField.sendKeys(sign);
        mSleep(5000);
        addSignButton.click();
        mSleep(5000);
    }

    private void waitint(String xpathElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }

    private void mSleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
