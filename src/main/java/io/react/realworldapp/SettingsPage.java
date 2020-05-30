package io.react.realworldapp;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

public SelenideElement getPageTitle(){
    return $(By.cssSelector("div>h1"));
}
}
