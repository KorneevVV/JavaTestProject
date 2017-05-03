package ru.aplana.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import ru.aplana.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user enter main yandex page")
    public void openYandexMainPage() {
        endUser.openMainYandexPage();
    }

    @When("the user click on mail button")
    public void openMailLoginPage() {
        endUser.goToLoginPage();
    }

    @When("the user type login and password and click enter")
    public void logIn() {
        endUser.logIn();
    }

    @When("the user create new mail and check podpis")
    public void writeNewMail() {
        endUser.writeNewMailAndCheckPodpis();
    }

    @When("the user should see success send mail")
    public void mailSendStatus() {
        endUser.sendMailStatus();
    }
    @When("user go to options")
    public void openOptions(){
        endUser.openOptions();
    }
    @Then("user change options")
    public void changeOptions(){
        endUser.optionsMoves();
    }
    @Then("check podpis")
    public void checkPodpis(){
        endUser.checkPod();
    }


}
