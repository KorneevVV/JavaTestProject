package ru.aplana.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

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
}
