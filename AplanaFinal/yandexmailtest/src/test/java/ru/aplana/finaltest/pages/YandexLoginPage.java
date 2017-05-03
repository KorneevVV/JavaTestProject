package ru.aplana.finaltest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class YandexLoginPage extends PageObject {

    @FindBy(name = "login")
    private WebElementFacade loginField;

    @FindBy(name = "passwd")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[contains(@class, 'nb-button _nb-action-button nb-group-start')]") ///////?????????
    private WebElementFacade enterBtn;

    public void logIn(String login, String password) {
        loginField.clear();
        loginField.type(login);
        passwordField.clear();
        passwordField.type(password);
        enterBtn.click();
    }

}
