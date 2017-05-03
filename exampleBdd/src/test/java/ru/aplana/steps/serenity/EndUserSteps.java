package ru.aplana.steps.serenity;

import ru.aplana.pages.githubLogin;
import net.thucydides.core.annotations.Step;



import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndUserSteps {

    githubLogin githubLogin;

    @Step
    public void check_username(String user) {
    assertTrue("Bad",githubLogin.check_username(user));
    }



    @Step
    public void is_the_home_page() {
        githubLogin.open();
    }

    @Step
    public void do_settings(String user) {
    githubLogin.do_set(user);
    }

    @Step
    public void login_account(String login, String password) {
    githubLogin.log_in(login,password);
    }

    @Step
    public void plusdate(){
        githubLogin.pd();}

}