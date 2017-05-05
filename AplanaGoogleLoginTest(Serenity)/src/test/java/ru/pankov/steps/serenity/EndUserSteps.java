package ru.pankov.steps.serenity;

import net.thucydides.core.annotations.Step;

import ru.pankov.pages.*;


public class EndUserSteps {

    BaseGooglePage baseGooglePage;
    GoogleAuthPagePartEmailPage googleAuthPagePartEmailPage;
    GoogleAuthPagePartPasswordPage googleAuthPagePartPasswordPage;
    GmailPage gmailPage;
    GoogleEditPage googleEditPage;

    @Step
    public void enterEmailButton() {
        baseGooglePage.lookup_emailButton();
    }

    @Step
    public void enterEditButtonVidget() {
        gmailPage.clickEdit1();
    }

    @Step
    public void enterLableEditButtonOnVidget() {
        gmailPage.clickEditInto();
    }

    @Step
    public void editPodpisyLabel() {
        googleEditPage.changePodpisyLabel();
    }
    @Step
    public void editCheckBoxChangePodpisyLabel() {
        googleEditPage.editCheckBoxChangePodpisyLabel();
    }
    @Step
    public void saveChangeEdit() {
        googleEditPage.saveChangeEdit();
    }

    @Step
    public void enterUsersEmail(String enterUsersEmail) {
        googleAuthPagePartEmailPage.enterEmail(enterUsersEmail);
    }
    @Step
    public void enterUsersPassword(String enterUsersPassword) {
        googleAuthPagePartPasswordPage.enterPassword(enterUsersPassword);
    }

    @Step
    public void goToRartPassword() {
        googleAuthPagePartEmailPage.goToRartPassword();
    }
    @Step
    public void singIn() {
        googleAuthPagePartPasswordPage.singIn();
    }


    @Step
    public void is_the_home_page() {
        baseGooglePage.open();

    }

    @Step
    public void LogInPartEmail(String email) {
        enterUsersEmail(email);
        goToRartPassword();
    }
    @Step
    public void LogInPartPass(String pass) {
        enterUsersPassword(pass);
        singIn();
    }

    @Step
    public void writeLetter(String email, String textLetter, String subj){
        gmailPage.writeEmail();
        gmailPage.writeAddress(email);
        gmailPage.writeTextEmail(textLetter);
        gmailPage.writeSubject(subj);
        gmailPage.sendEmail();
    }

}