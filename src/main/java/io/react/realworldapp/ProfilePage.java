package io.react.realworldapp;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    private By profilePage = By.className("user-img");

    public boolean isPageOpened(){
        return $(profilePage).isDisplayed();
    }


    public List<String> getAllArticleTitles() {
        List<String> titles = new ArrayList<>();
        ElementsCollection elements = $$(".article-preview h1");
        elements.forEach(element -> titles.add(element.getText()));
        return titles;
    }
}
