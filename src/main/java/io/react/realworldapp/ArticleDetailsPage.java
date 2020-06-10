package io.react.realworldapp;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ArticleDetailsPage {
    private By articlePage = By.cssSelector(".article-page");

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("form>fieldset>button");


    public boolean isPageOpened(){
        return $(articlePage).isDisplayed();
    }

    @Feature("Article")
    @Severity(SeverityLevel.CRITICAL)
    @Step ("Edit Article")
    public void editArticleTitle(String title){
        $(titleField).setValue(title);
    }

    public void editArticleBody(String body){
        $(articleBodyField).setValue(body);
    }

    public void editArticleAbout(String whatAbout){
        $(whatAboutField).setValue(whatAbout);
    }

    public void editArticleTag(String tag){
        $(tagsField).setValue(tag);
    }

    public void publishArticle(){
        $(publishArticleBtn).click();
    }
}
