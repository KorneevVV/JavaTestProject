package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.yandex.ru/")
public class YandexMainPage extends PageObject {

    @FindBy(xpath = "//a[@href='https://mail.yandex.ru']")
    private WebElementFacade mailBtn;

    public void enterMailPage() {
        mailBtn.click();
    }

}
