package ru.pankov.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ru.pankov.steps.serenity.EndUserSteps;


public class EmailSteps {

    @Steps
    EndUserSteps endUser;

    @Given("пользователь на домашней странице Гугл")
    public void givenTheUserIsOnTheGoogleHomePage() {
        endUser.is_the_home_page();
    }

    @When("пользователь переходит на страницу аутентификации почты")
    public void whenTheUserLooksUpTheEmailButton() {
        endUser.enterEmailButton();
    }

    @When("вводим почту '$email'")
    public void whenTheUserWriteEmailPatr(String email) {
        endUser.LogInPartEmail(email);
    }

    @When("вводим пароль от почты '$pass' и авторизуемся")
    public void whenTheUserWritePasswordPatr(String pass) {
        endUser.LogInPartPass(pass);
    }

    @Then("пишем письмо - адрессат: '$email', текст письма : '$textLetter'")
    public void whenTheUserWriteLetter(String email, String textLetter) {
        endUser.writeLetter(email,textLetter);
    }
}

