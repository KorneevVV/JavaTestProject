package ru.aplana.finaltest.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.finaltest.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("User enter main yandex page, go to mail page and log in")
    public void logInYandexMail(){endUser.logIn();}

    @When("User edit user's data settings")
    public void editDataSetting(){
        endUser.openUserDataSettings();
        endUser.editUserDataSetting();
    }

    @When("User go to mails")
    public void UserGoToMails(){
        endUser.goToMails();
    }

    @Then("User create new mail and check the sign")
    public void UserCheckSign(){
        endUser.createNewMailCheckSign();
    }

}
