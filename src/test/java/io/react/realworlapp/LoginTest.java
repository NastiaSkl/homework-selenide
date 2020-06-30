package io.react.realworlapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.react.realworldapp.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends TestBase{

    private LoginPage loginPage = new LoginPage();


    @BeforeMethod
    public void setUp() {

        Configuration.baseUrl = "https://react-redux.realworld.io/";
        open(Configuration.baseUrl);


    }

    @Test
    public void openPage() {

        $("a[href='#login']").shouldBe(Condition.visible).click();
    }

    @Test
    public void loginTest(){

        String userName = "realapp512";
        String email = "realapp512@email.com";
        String password = "qwerty123";

        loginPage
                .openPage()
                .login(email, password)
                .userShouldBeLoggedIn(userName);
        }
    }

