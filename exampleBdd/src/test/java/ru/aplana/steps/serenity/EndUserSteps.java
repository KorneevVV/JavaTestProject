package ru.aplana.steps.serenity;

import ru.aplana.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import ru.aplana.pages.MailMainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {
    MailMainPage mailMainPage;

    DictionaryPage dictionaryPage;
    @Step
    public void find_mail() {
        mailMainPage.find_mail_btn();
    }
    @Step
    public void login(String login) {
        mailMainPage.enter_login(login);
    }
    @Step
    public void enter_password(String password) {
        mailMainPage.enter_password(password);
    }
    @Step
    public void logIn() {
        mailMainPage.logIn();
    }
    @Step
    public void create_new_mail() {
        mailMainPage.wtiteNewMail();
    }
    @Step
    public void enter_address(String address) {
        mailMainPage.enter_address(address);
    }
    @Step
    public void enter_sub(String sub) {
        mailMainPage.enter_Sub(sub);
    }
    @Step
    public void type_mail(String mail) {
        mailMainPage.type_mail(mail);
    }
    @Step
    public void send_mail() {
        mailMainPage.send_mail();
    }
    @Step
    public void is_the_home_page() {
        mailMainPage.open();
    }
}