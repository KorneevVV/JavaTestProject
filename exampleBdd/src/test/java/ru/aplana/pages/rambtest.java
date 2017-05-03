package ru.aplana.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.Date;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://mail.rambler.ru/")
public class rambtest extends PageObject {

    @FindBy(xpath="//input[@name='login']")
    private WebElementFacade loginField;

    @FindBy(xpath="//input[@name='password']")
    private WebElementFacade pField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade SignIn;

    public void log_in(String login,String password) {
        loginField.clear();
        loginField.type(login);
        pField.clear();
        pField.type(password);
        SignIn.click();
    }

    public void add_username(String username) {
        find(By.xpath("//a[@href='#/compose']")).click();
        find(By.xpath("//input[@id='receivers']")).clear();
        find(By.xpath("//input[@id='receivers']")).sendKeys("vo1k@list.ru");
        find(By.xpath("//input[@id='subject']")).clear();
        find(By.xpath("//input[@id='subject']")).sendKeys("test");
        find(By.xpath("//body[@data-id='editor']")).clear();
        find(By.xpath("//body[@data-id='editor']")).sendKeys("test");
        find(By.xpath("//button[@type='button'])[11]")).click();
    }

    public void add_datas(String datas) {
        Date date = new Date();

        find(By.xpath("//a[@data-for='settings-type'] ")).click();
        find(By.xpath("//textarea[@name='signature']")).clear();
        find(By.xpath("//textarea[@name='signature']")).sendKeys("Пишу Вам " + date.toString());
        find(By.xpath("//button[@type='submit']")).click();
        find(By.xpath("//a[@href='#/compose']")).click();
        getDriver().switchTo().frame("editor_ifr");
        find(By.xpath("//body[@id='tinymce']")).click();
        getDriver().switchTo().defaultContent();
    }
    public boolean check_datas(String datas) {

        return find(By.xpath("//body[@id='tinymce'],'"+datas+"')]")).isEnabled();

    }

    public boolean check_username(String username) {

        return find(By.xpath("//a[@class='rambler-topline-user-dropdown__logout']")).isEnabled();

    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}