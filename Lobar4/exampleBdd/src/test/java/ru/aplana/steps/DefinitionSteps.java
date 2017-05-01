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
}
