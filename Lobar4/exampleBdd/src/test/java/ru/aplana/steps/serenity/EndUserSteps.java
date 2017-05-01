package ru.aplana.steps.serenity;

import ru.aplana.pages.HomePage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    HomePage homePage;

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
}
