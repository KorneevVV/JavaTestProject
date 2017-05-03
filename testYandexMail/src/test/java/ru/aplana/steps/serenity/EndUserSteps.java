package ru.aplana.steps.serenity;

import net.thucydides.core.annotations.Step;
import ru.aplana.pages.OptionsPage;
import ru.aplana.pages.YandexLoginPage;
import ru.aplana.pages.YandexMailPage;
import ru.aplana.pages.YandexMainPage;

public class EndUserSteps {

    User user = new User("DmitriyZotovTest", "DmitriyZotovTest007");
    YandexMainPage yandexMainPage;
    YandexLoginPage yandexLoginPage;
    YandexMailPage yandexMailPage;
    OptionsPage optionsPage;

    @Step
    public void openMainYandexPage() {
        yandexMainPage.open();
    }

    @Step
    public void goToLoginPage() {
        yandexMainPage.enterMailPage();
    }

    @Step
    public void logIn() {
        yandexLoginPage.logIn(user.getLogin(), user.getPassword());
    }

    @Step
    public void writeNewMailAndCheckPodpis() {
        yandexMailPage.writeNewMailAndCheckPodpis();
    }

    @Step
    public void sendMailStatus() {
        yandexMailPage.checkMailStatus("Письмо отправлено.");
    }

    @Step
    public void openOptions(){
        yandexMailPage.clickOptions();
        yandexMailPage.userDataOptionsClick();
    }
    @Step
    public void optionsMoves(){
        optionsPage.enterUserName("Dima Zotov");
        optionsPage.addPodpis();
    }
    @Step
    public void checkPod(){
        yandexMailPage.writeNewMailAndCheckPodpis();
    }
}