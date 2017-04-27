package ru.aplana.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://github.com/login")
public class githubLogin extends PageObject {

    @FindBy(xpath="//*[@id='login_field']")
    private WebElementFacade loginField;

    @FindBy(xpath="//*[@id='password']")
    private WebElementFacade pField;

    @FindBy(xpath="//*[contains(@value,'Sign in')]")
    private WebElementFacade SignIn;

    public void log_in(String login,String password) {
        loginField.clear();
        loginField.type(login);
        pField.clear();
        pField.type(password);
        SignIn.click();
    }

    public void add_username(String username) {
        find(By.xpath("//*[@id='repo_listing']/li[2]/a")).click();
        find(By.xpath("//nav[contains(@class,'reponav')]/a[last()]")).click();
        find(By.xpath("//*[contains(@href,'/settings/collaboration')]")).click();
        find(By.xpath("//*[@id='search-member']")).clear();
        find(By.xpath("//*[@id='search-member']")).type(username);
        find(By.xpath("//*[@data-autocomplete-value='"+username+"']")).click();
        find(By.xpath("//*[contains(@class,'add-new-collab')]")).click();
    }

    public boolean check_username(String username) {

        return find(By.xpath("//form[contains(@action,'"+username+"')]")).isEnabled();

    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}