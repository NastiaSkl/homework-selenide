package io.react.realworldapp;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage{

    private static Logger LOG = LoggerFactory.getLogger(LoginPage.class);

    private By authForm = byCssSelector(".auth-page");
    private By loginLink = byAttribute("href", "#login");
    private By emailField = byCssSelector("input[type='email']");
    private By passwordField = byCssSelector("input[type='password']");
    private By signInBtn = byCssSelector("button[type='submit']");

    private By loginInAuthForm = new ByChained(authForm, emailField);

    public HomePage login(String email, String password){
        inputPassword(password);
        inputEmail(email);
        return clickSignInButton();
    }
    @Feature("User Login")
    @Severity(SeverityLevel.BLOCKER)
    @Step ("Open Login page")
    public LoginPage openPage() {
        $(loginLink).shouldBe(Condition.visible).click();
        return this;
    }

    public String getPageTitle() {
        return $(".auth-page h1").text();
    }

    public void inputEmail(String email){
        $(loginInAuthForm).setValue(email);
    }

    public void inputPassword(String password){
        $(passwordField).setValue(password);

    }

    @Step ("Click SignIn button")
    public HomePage clickSignInButton() {
       $(signInBtn).click();
        return new HomePage();
    }


}
