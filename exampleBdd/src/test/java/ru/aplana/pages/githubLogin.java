package ru.aplana.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;

import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.Locale;

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

    public void do_set(String username) {
        find(By.xpath("//a[contains(@aria-label,'profile')]")).click();
        find(By.xpath("//a[contains(@href,'settings')]")).click();
        find(By.xpath("//input[contains(@id,'contribution')]")).click();
        find(By.xpath("//button[contains(.,'contributions')]")).click();
        find(By.xpath("//input[contains(@id,'name')]")).clear();
        find(By.xpath("//input[contains(@id,'name')]")).type(username);
        find(By.xpath("//button[contains(.,'e profile')]")).click();
        find(By.xpath("//a[contains(.,'view your profile')]")).click();

    }

    public boolean check_username(String username) {

        return find(By.xpath("//span[contains(.,'"+username+"')]")).isEnabled();

    }

    public void pd(){
        try {
            String s = find(By.xpath("//*[@id='js-contribution-activity']/div[1]/div/h3")).getText();
            DateFormat formatt = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
            Date date = formatt.parse(s);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year  = cal.get(Calendar.YEAR);
            int month = (cal.get(Calendar.MONTH)+2);
            int day   = cal.get(Calendar.DAY_OF_MONTH);
            String outputDate = (day+"."+month+"."+year);
            System.out.println(outputDate);
        } catch (ParseException ex){}
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}