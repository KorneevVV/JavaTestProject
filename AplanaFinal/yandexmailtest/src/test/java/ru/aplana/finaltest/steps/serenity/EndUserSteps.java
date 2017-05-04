package ru.aplana.finaltest.steps.serenity;

import net.thucydides.core.annotations.Step;
import ru.aplana.finaltest.model.User;
import ru.aplana.finaltest.pages.SettingsPage;
import ru.aplana.finaltest.pages.YandexLoginPage;
import ru.aplana.finaltest.pages.YandexMailPage;
import ru.aplana.finaltest.pages.YandexPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EndUserSteps {
    User user_1 = new User("DmitriyZotovTest", "DmitriyZotovTest007");
    YandexPage yandexPage;
    YandexLoginPage yandexLoginPage;
    YandexMailPage yandexMailPage;
    SettingsPage settingsPage;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

    @Step
    public void logIn() {
        yandexPage.open();
        yandexPage.enterMailPage();
        yandexLoginPage.logIn(user_1.getLogin(), user_1.getPassword());
    }

    @Step
    public void openUserDataSettings() {
        yandexMailPage.openSettings();
        yandexMailPage.openUserDataSettings();
    }

    @Step
    public void editUserDataSetting() {
        settingsPage.enterUserName(user_1.getLogin());
        settingsPage.addSign(dateFormat.format(date));
    }

    @Step
    public void createNewMailCheckSign() {
        yandexMailPage.writeNewMailForChecking();
        yandexMailPage.checkSign(dateFormat.format(date));
    }

    @Step
    public void goToMails() {
        yandexMailPage.open();

    }
}
