package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.util.*;

import static org.junit.Assert.assertTrue;

@DefaultUrl("http://vk.com")
public class HomePage extends PageObject {

    @FindBy(xpath = "//input[@id='index_email']")
    private WebElementFacade login;

    @FindBy(xpath = "//input[@id='index_pass']")
    private WebElementFacade password;

    @FindBy(xpath = "//button[@id='index_login_button']")
    private WebElementFacade signInButton;

    @FindBy(xpath = "//span[contains(.,'Моя Страница')]")
    private WebElementFacade linkMyPage;

    @FindBy(xpath = "//input[@id='ts_input']")
    private WebElementFacade searchBar;

    @FindBy(xpath = "//span[contains(.,'Показать все результаты')]")
    private WebElementFacade showResults;

    @FindBy(xpath = "//a[@class='ui_rmenu_item _ui_item_people search_menu_people']")
    private WebElementFacade people;

    @FindBy(xpath = "//div[@id=\"cCountry\"]/descendant::input[@class=\"selector_input\"]")
    private WebElementFacade listCountry;

    @FindBy(xpath = "//div[@id=\"cCity\"]/descendant::input[@class=\"selector_input\"]")
    private WebElementFacade listCity;

    @FindBy(xpath = "//div[@id=\"results\"]/div[1]")
    private WebElementFacade listOfSerchResults;

    @FindBy(xpath = "//a[@id='top_profile_link']")
    private WebElementFacade linkProfile;

    @FindBy(xpath = "//a[@id='top_edit_link']")
    private WebElementFacade linkEdit;

    @FindBy(xpath = "//div[@class='page_block_header' and contains(.,'Основное')]")
    private WebElementFacade linkHeader;

    @FindBy(xpath = "//div[@class='pedit_bday fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownDay;

    @FindBy(xpath = "//div[@class='pedit_bmonth fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownMonth;

    @FindBy(xpath = "//div[@class='pedit_byear fl_l']/div/table/tbody/tr/td[@class='selector_dropdown']")
    private WebElementFacade linkDropdownYears;

    @FindBy(xpath = "//button[@class='flat_button button_big_width']")
    private WebElementFacade linkSave;

    public void enterLogin(String keyword) {
        login.type(keyword);
    }

    public void enterPass(String keyword) {
        password.type(keyword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean takeLinkMyPage() {
        return linkMyPage.isEnabled();
    }

    public void searchOnBar(String name) {
        searchBar.click();
        searchBar.sendKeys(name);
        showResults.isVisible();
        showResults.click();
        people.click();
    }

    public void selectListCountry(String country) {
        listCountry.click();
        String xPath = "//li[contains(.,'" + country + "')]";
        WebElementFacade selectedCountry = find(By.xpath(xPath));
        selectedCountry.isVisible();
        selectedCountry.click();
    }

    public void selectListCity(String city) {
        listCity.click();
        String xPath = "//li[contains(.,'" + city + "')]";
        WebElementFacade selectedCity = find(By.xpath(xPath));
        selectedCity.isVisible();
        selectedCity.click();
    }

    public void checkResultSearch() {
        assertTrue(listOfSerchResults.isDisplayed());
    }

    public void clickSetting() {
        linkProfile.click();
        linkEdit.isVisible();
        linkEdit.click();
        assertTrue(linkHeader.isVisible());
    }

    public void changeDate(Integer yearsInt) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR) - yearsInt;
        int month = calendar.get(Calendar.MONTH) + 1; // январь - 0, т.о. май - 4
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        linkDropdownDay.isVisible();
        linkDropdownDay.click();
        String xPathDay = "//div[@class='pedit_bday fl_l']/div/div/div/ul/li[" + day + "]";
        WebElementFacade selectedDay = find(By.xpath(xPathDay));
        selectedDay.isVisible();
        selectedDay.click();

        linkDropdownMonth.click();
        String xPathMonth = "//div[@class='pedit_bmonth fl_l']/div/div/div/ul/li[" + month + "]";
        WebElementFacade selectedMonth = find(By.xpath(xPathMonth));
        selectedMonth.isVisible();
        selectedMonth.click();

        linkDropdownYears.click();
        String xPathYears = "//div[@class='pedit_byear fl_l']/div/div/div/ul/li[contains(.," + year + ")]"; // [contains(.,2003)]
        WebElementFacade selectedYears = find(By.xpath(xPathYears));
        selectedYears.isVisible();
        selectedYears.click();
        linkSave.click();
    }

    public void checkMsg(String msg) {
        String xPath = "//b[contains(.,'" + msg + "')]";
        WebElementFacade linkMsg = find(By.xpath(xPath));
        assertTrue(linkMsg.isVisible());
    }
}
