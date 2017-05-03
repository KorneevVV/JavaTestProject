package ru.pankov.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.Date;

/**
 * Created by x5retail on 03.05.2017.
 */
public class GoogleEditPage extends PageObject {
    private Date currentDate;
    @FindBy(xpath = "//div[@aria-label='Подпись']")
    private WebElementFacade keyWord;

    @FindBy(xpath = "//*[@id=':59']")
    private WebElementFacade checkBox;
    @FindBy(xpath = "//button[.='Сохранить изменения']")
    private WebElementFacade changeEdit;

    public void changePodpisyLabel(){
        keyWord.click();
        keyWord.clear();
        currentDate = new Date();
        keyWord.sendKeys("текущая дата " + currentDate.getDate());
    }
    public void editCheckBoxChangePodpisyLabel(){
        checkBox.click();
    }
    public void saveChangeEdit(){
        changeEdit.click();
    }
}
