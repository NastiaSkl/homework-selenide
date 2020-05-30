package io.react.realworlapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfileTest extends TestBase {

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
        login();
    }



    @Test
    public void checkPageOpened(){

        $("li:nth-child(4)").click();
        $(By.className("action-btn")).shouldBe(Condition.visible);

    }
}
