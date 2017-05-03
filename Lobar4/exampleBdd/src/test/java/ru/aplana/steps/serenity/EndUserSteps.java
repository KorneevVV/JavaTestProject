package ru.aplana.steps.serenity;

import org.junit.Assert;
import ru.aplana.pages.HomePage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class EndUserSteps {

    private HomePage homePage;

    @Step
    public void is_the_home_page() {
        homePage.open();
    }

    @Step
    public void enters_login(String keyword) {
        homePage.enterLogin(keyword);
    }

    @Step
    public void enters_pass(String keyword) {
        homePage.enterPass(keyword);
    }

    @Step
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @Step
    public void checkSignIn(String title) {
        assertTrue(homePage.takeLinkMyPage());
        Assert.assertEquals(title, homePage.getTitle());
    }

    @Step
    public void checkSignIn() {
        assertTrue(homePage.takeLinkMyPage());
    }

    @Step
    public void searchUser(String name) {
        homePage.searchOnBar(name);
    }

    @Step
    public void selectionCountry(String country) {
        homePage.selectListCountry(country);
    }

    @Step
    public void selectionCity(String city) {
        homePage.selectListCity(city);
    }

    @Step
    public void checkResultSearch() {
        homePage.checkResultSearch();
    }
    
    @Step
    public void clickSetting() {
        homePage.clickSetting();
    }

    @Step
    public void changeDate(Integer yearsInt) {
        homePage.changeDate(yearsInt);
    }

    @Step
    public void checkMsg(String msg) {
        homePage.checkMsg(msg);
    }

    @Step
    public void clickMyPage() {
        homePage.clickMyPage();
    }

    @Step
    public void checkChangeBDay() {
        homePage.checkChangeBDay();
    }
}
