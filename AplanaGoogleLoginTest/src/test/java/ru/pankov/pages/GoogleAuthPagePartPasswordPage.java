package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by kracoz on 03.05.2017.
 */
public class GoogleAuthPagePartPasswordPage extends PageObject {
    @FindBy(xpath = "//*[@id='Passwd']|//input[@type='password']")
    private WebElementFacade password;

    @FindBy(xpath = "//*[@id='signIn']|//*[@id='passwordNext']")
    private WebElementFacade signIn;

    public void enterPassword(String enterUsersPass) {

        password.clear();
        password.sendKeys(enterUsersPass);
    }
    public void singIn() {
        signIn.click();
    }
}
