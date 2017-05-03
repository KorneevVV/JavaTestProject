package ru.aplana.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("пользователь входит в свою учетную запись с логином '$user' и паролем '$password'")
    public void givenTheUserIsOnTheWikionaryHomePage(String login,String password) {
        endUser.is_the_home_page();
        endUser.login_account(login,password);
    }

    @When("когда пользователь изменил имя в настройках на '$user' и поставил необходимые настройки")
    public void whenTheUserLooksUpTheDefinitionOf(String user) {
        endUser.do_settings(user);
    }

    @Then("пользователь должен увидеть имя '$user' в профиле.")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String user) {
        endUser.check_username(user);
        endUser.plusdate();
    }

}
