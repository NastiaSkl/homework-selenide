package io.react.realworldapp;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    @Step ("User should be logged in")
    public HomePage userShouldBeLoggedIn(String userName) {
        $("[href='#@" +userName+"']").shouldBe(Condition.visible.because("User not logged in!"));
        return this;
    }


    public ArticlePage clickNewPost(){
        $("[href='#editor']").click();
        return new ArticlePage();
    }

    public ProfilePage openProfile(){
        $("li:nth-child(4)").click();
        return new ProfilePage();
    }

    public SettingsPage openSettingsPage(){
        $("li:nth-child(3)").click();
        return new SettingsPage();
    }
}
