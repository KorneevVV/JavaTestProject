package ru.aplana.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;
@DefaultUrl("https://yandex.ru")
public class MailMainPage extends PageObject {

    @FindBy(xpath="//div//a[@href='https://mail.yandex.ru']")
    private WebElementFacade mail_btn;

    @FindBy(name="login")
    private WebElementFacade loginField;

    @FindBy(name="passwd")
    private WebElementFacade passwdField;

    @FindBy(xpath="//button[@class='nb-button _nb-action-button nb-group-start']")
    private WebElementFacade enterButton;

    @FindBy(xpath="//a[@class='mail-ComposeButton js-left-col-toolbar-compose']")
    private WebElementFacade writeNewMailbtn;

    @FindBy(xpath="(//div[@class='mail-Compose-Field-Input'])[1]")
    private WebElementFacade addressField;

    @FindBy(xpath="(//div[@class='mail-Compose-Field-Input'])[4]")
    private WebElementFacade subField;

    @FindBy(xpath="div[@class='cke_contents cke_reset']")
    private WebElementFacade textField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade submitBtn;

    public void enter_login(String login){
        loginField.clear();
        loginField.type(login);
    }

    public void enter_password(String password){
        passwdField.clear();
        passwdField.type(password);
    }

    public void find_mail_btn(){mail_btn.click();}

    public void logIn(){enterButton.click();}

    public void wtiteNewMail(){writeNewMailbtn.click();}

    public void enter_address(String address){addressField.type(address);}

    public void enter_Sub(String sub){subField.type(sub);}

    public void type_mail(String mail){textField.type(mail);}

    public void send_mail(){submitBtn.click();}


    /*public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }*/
}