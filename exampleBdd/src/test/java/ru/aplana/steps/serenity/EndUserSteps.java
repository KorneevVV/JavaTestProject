package ru.aplana.steps.serenity;

import ru.aplana.pages.rambtest;
import net.thucydides.core.annotations.Step;



import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndUserSteps {

    rambtest rambtest;

    @Step
    public void check_username(String user) {
    assertTrue("Bad",rambtest.check_username(user));
    }


    @Step
    public void is_the_home_page() {
        rambtest.open();
    }

    @Step
    public void add_datas(String datas) {
        rambtest.add_datas(datas);
    }

    @Step
    public void check_datas(String datas) {
        assertTrue("Bad",rambtest.check_datas(datas));
    }

    @Step
    public void add_user(String user) {
        rambtest.add_username(user);
    }

    @Step
    public void login_account(String login, String password) {
    rambtest.log_in(login,password);
    }


}