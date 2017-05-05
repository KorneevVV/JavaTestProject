package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * Created by kracoz on 02.05.2017.
 */
public class GoogleAuthPagePartEmailPage extends PageObject {
    @FindBy(xpath = "//input[@id='Email']|//input[@type='email']")
    private WebElementFacade email;

    @FindBy(xpath = "//*[@id='next']|//*[@id='identifierNext']")
    private WebElementFacade next;

    public void enterEmail(String enterUsersEmail) {

        //email.type(enterUsersEmail);
        email.clear();
        email.sendKeys(enterUsersEmail);
    }

    public void goToRartPassword() {
        next.click();
    }
}
