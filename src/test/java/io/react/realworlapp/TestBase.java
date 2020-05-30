package io.react.realworlapp;

import com.codeborne.selenide.Configuration;
import io.react.realworldapp.HomePage;
import io.react.realworldapp.LoginPage;
import io.react.realworldapp.model.User;
import io.react.realworldapp.model.UserData;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    static {
        Configuration.baseUrl = "https://react-redux.realworld.io/";
    }

    public void login(){
        LoginPage loginPage = new LoginPage();
        $("a[href='#login']").click();
        User user = UserData.defaultUser();
        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
    }
}
