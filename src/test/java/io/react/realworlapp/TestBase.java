package io.react.realworlapp;

import com.codeborne.selenide.Configuration;
import io.react.realworldapp.HomePage;
import io.react.realworldapp.LoginPage;
import io.react.realworldapp.model.User;
import io.react.realworldapp.model.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    static {
        //added option to run all tests that extend this class in remote browser.

        Configuration.baseUrl = "https://react-redux.realworld.io/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("83.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void login(){
        LoginPage loginPage = new LoginPage();
        $("a[href='#login']").click();
        User user = UserData.defaultUser();
        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
    }
}
