package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by x5retail on 03.05.2017.
 */
public class GoogleEditPage extends PageObject {
    private Calendar currentDate;
    @FindBy(xpath = "//div[@aria-label='Подпись']")
    private WebElementFacade signature;

    @FindBy(xpath = "//label[.='Добавлять эту подпись перед цитируемым текстом в ответных сообщениях и удалять строку \"--\" перед ней']")
    private WebElementFacade checkBox;
    @FindBy(xpath = "//button[.='Сохранить изменения']")
    private WebElementFacade changeEdit;

    public void changePodpisyLabel(){
        signature.click();
        signature.clear();
        currentDate = new GregorianCalendar();
        signature.sendKeys("текущая дата " + currentDate.getTime());
    }
    public void editCheckBoxChangePodpisyLabel(){
        checkBox.click();
    }
    public void saveChangeEdit(){
        changeEdit.click();
    }
}
