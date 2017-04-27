package ru.aplana.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Github Login page and input login '$login' and password '$password'")
    public void givenTheUserIsOnTheWikionaryHomePage(String login,String password) {
        endUser.is_the_home_page();
        endUser.login_account(login,password);
    }

    @When("a user add a collaborator '$user' to the second project in his Github")
    public void whenTheUserLooksUpTheDefinitionOf(String user) {
        endUser.add_user(user);
    }

    @Then("he should see the user name of collaborator '$user' in the list of collaborators and exit the account")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String user) {
        endUser.check_username(user);
    }

}
