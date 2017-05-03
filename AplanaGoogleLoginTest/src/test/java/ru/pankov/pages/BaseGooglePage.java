package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by kracoz on 03.05.2017.
 */


@DefaultUrl("https://www.google.ru/")
public class BaseGooglePage extends PageObject{

    @FindBy(xpath = "//div[.='Почта']")
    private WebElementFacade searchEmailButton;

    public void lookup_emailButton() {
        searchEmailButton.click();
    }

}
