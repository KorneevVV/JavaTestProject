package ru.aplana.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUsersSteps;

    @Given("пользователь открывает главную страницу VK")
    public void givenTheUserIsOnTheVKHomePage() {
        endUsersSteps.is_the_home_page();
    }

    @When("пользователь вводит login: '$login' и password: '$pass'")
    public void whenTheUserSignIn(String login, String pass) {
        endUsersSteps.enters_login(login);
        endUsersSteps.enters_pass(pass);
        endUsersSteps.clickSignInButton();
    }

    @Then("происходит авторизация пользователя")
    public void thenSignIn() {
        endUsersSteps.checkSignIn();
    }

    @Then("происходит авторизация пользователя и заголовок страницы '$title'")
    public void thenSignIn(String title) {
        endUsersSteps.checkSignIn(title);
    }

    @When("поиск пользователя: '$name' страна: '$country' город: '$city'")
    public void whenSearchUsers(String name, String country, String city) {
        endUsersSteps.searchUser(name);
        endUsersSteps.selectionCountry(country);
        endUsersSteps.selectionCity(city);
    }

    @Then("будут найдены пользователи согласно условиям")
    public void thenCheckResultSearch() {
        endUsersSteps.checkResultSearch();
    }

    @When("пользователь переходит в настройки")
    public void whenTheUsersClickSetting() {
        endUsersSteps.clickSetting();
    }

    @When("пользователь изменяет дату рождения на текущую - '$years' лет")
    public void whenTheUsersChangeDate(String years) {
        Integer yearsInt = new Integer(years);
        endUsersSteps.changeDate(yearsInt);
    }

    @Then("появляется сообщение '$msg'")
    public void thenCheckMsg(String msg) {
        endUsersSteps.checkMsg(msg);
    }

}
