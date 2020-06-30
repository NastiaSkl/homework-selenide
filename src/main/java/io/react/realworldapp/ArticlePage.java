package io.react.realworldapp;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage {
    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("form>fieldset>button");

    static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

    public void inputArticleTitle(String title){
        $(titleField).setValue(title);
    }

    public void inputArticleAbout(String whatAbout){
        $(whatAboutField).setValue(whatAbout);
    }

    public void inputArticle(String body){
        $(articleBodyField).setValue(body);
    }

    public void inputArticleTags(String tags){
        $(tagsField).setValue(tags);
    }

    @Step ("Click Publish Article Button")
    public ArticleDetailsPage clickPublishArticleBtn(){
        LOG.info("Publich article");
        $(publishArticleBtn).click();
        return new ArticleDetailsPage();
    }
}
