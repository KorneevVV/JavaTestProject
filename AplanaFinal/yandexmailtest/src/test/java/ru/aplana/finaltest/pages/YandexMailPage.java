package ru.aplana.finaltest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@DefaultUrl("https://mail.yandex.ru/?uid=494578487&login=dmitriyzotovtest#inbox")
public class YandexMailPage extends PageObject {
    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]")
    private WebElementFacade writeMailButton;

    @FindBy(xpath = "//div[@name='to']")
    private WebElementFacade addressField;

    @FindBy(xpath = "//input[@name='subj']")
    private WebElementFacade subjField;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//div[4]")
    private WebElementFacade mailTextField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade sendMailButton;

    @FindBy(xpath = "//a[@class='mail-GhostButton js-header-settings nb']")
    private WebElementFacade settingsBtn;

    @FindBy(xpath = "(//span[@class='settings-popup-menu-item-content'])[1]")
    private WebElementFacade settingsButtonUserData;

    @FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
    private WebElementFacade signLabel;

    public void writeNewMail(String address, String sub, String text) {
        waiting("//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]");
        writeMailButton.click();
        addressField.clear();
        addressField.type(address);
        subjField.clear();
        subjField.type(sub);
        mailTextField.type(text);
        sendMailButton.click();
    }

    public void writeNewMailForChecking() {
        waiting("//a[contains(@class, 'mail-ComposeButton js-left-col-toolbar-compose')]");
        writeMailButton.click();
    }

    public void openSettings() {
        waiting("//a[@class='mail-GhostButton js-header-settings nb']");
        settingsBtn.click();
    }

    public void openUserDataSettings() {
        waiting("(//span[@class='settings-popup-menu-item-content'])[1]");
        settingsButtonUserData.click();
    }

    public String findSign() {
        return signLabel.getText();
    }

    public void checkSign(String valueOfSign) {
        waiting("//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']");
        assertTrue("sign = " + findSign() + "\n edited sign = " + valueOfSign
                + "sign is not equals", findSign().equals("-- \n" + valueOfSign));
        //Яндекс добавлял к подписи "--\n" которые мы не прописываи когда редактировали подпись
        //поэтому тест тут валился
    }

    private void waiting(String xpathElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
    }
}
