package ru.aplana.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("зайти на почту рамблер по данными логин '$login' и пароль '$password'")
    public void givenTheUserIsOnTheWikionaryHomePage(String login,String password) {
        endUser.is_the_home_page();
        endUser.login_account(login,password);
    }

    @When("зайти в настройки, изменить подпись на дату '$datas' потом проверить эту подпись в письме")
    public void whenTheUserLooksUpTheDefinitionOfs(String datas) {
        endUser.add_datas(datas);
    }
    @When("зайти в форму написать письмо, заполнить поля и отправить '$user'")
    public void whenTheUserLooksUpTheDefinitionOf(String user) {
        endUser.add_user(user);
    }

    @Then("если не дает отправить, выйти из аккаунта")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String user) {
        endUser.check_username(user);
    }

}
