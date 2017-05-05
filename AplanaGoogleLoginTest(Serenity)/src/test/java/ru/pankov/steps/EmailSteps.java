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
    @When("Выбираем виджет настроек")
    public void whenTheUserClickEditButtonVidget() {
        endUser.enterEditButtonVidget();
    }

    @When("Устанавливаем подпись в виде текущей даты")
    public void whenTheUserСhangePodpisyLabel() {
        endUser.editPodpisyLabel();
    }

    @When("меняем чекбокс подписи")
    public void whenTheUserСhangeCheckBox() {
        endUser.editCheckBoxChangePodpisyLabel();
    }
    @When("Сохраняем изменения в настройках")
    public void whenTheUserSaveChangeEdit() {
        endUser.saveChangeEdit();
    }
    @When("Выбираем вкладку НАСТРОЙКИ в выпадающем списке виджета настроек")
    public void whenTheUserClickLableEditButtonOnVidget() {
        endUser.enterLableEditButtonOnVidget();
    }
    @Then("пишем письмо - адрессат: '$email', текст письма : '$textLetter',тема письма:'$subject'")
    public void whenTheUserWriteLetter(String email, String textLetter, String subject) {
        endUser.writeLetter(email,textLetter, subject);
    }
 }

