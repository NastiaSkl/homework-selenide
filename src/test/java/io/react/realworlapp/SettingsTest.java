package io.react.realworlapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.react.realworldapp.SettingsPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SettingsTest extends TestBase{

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
        login();
        $("a[href=\"#settings\"]").click();

    }

    @Test
    public void checkPageOpened(){
        SettingsPage settingsPage = new SettingsPage();
        SelenideElement pageHeader = settingsPage.getPageTitle();
        $(pageHeader).getText().equals("Your Settings");
    }
//
//    @Test
//    public void updateSettings(){
//        $(":nth-child(3)>textarea").setValue("Quoka is a funny animal"); //populate user bio
//        sleep(4000);
//        SelenideElement updateBtn = $("button[type=\"submit\"]").scrollTo();
//        updateBtn.click();
//    }


    @Test
    public void userLogout(){
        SelenideElement logoutBtn = $(By.className("btn-outline-danger")).scrollTo();
        logoutBtn.click();
        $("a[href=\"#register\"]").shouldBe(Condition.visible);

    }


}
