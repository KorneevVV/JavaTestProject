package ru.aplana.finaltest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.yandex.ru/")
public class YandexPage extends PageObject {
    @FindBy(xpath = "//a[@href='https://mail.yandex.ru']")
    private WebElementFacade mailButton;

    @FindBy(xpath = "//a[@class='link link_black_yes domik2__notification domik2__notification_type_mail i-bem link_js_inited']")
    private WebElementFacade mailBtn;

    public void enterMailPage() {
        mailButton.click();
    }
}
