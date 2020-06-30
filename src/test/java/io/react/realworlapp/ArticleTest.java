package io.react.realworlapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.react.realworldapp.config.BrowserConfiguration;
import io.react.realworldapp.ArticleDetailsPage;
import io.react.realworldapp.HomePage;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ArticleTest extends TestBase {

    private BrowserConfiguration browserConfiguration = ConfigFactory.create(BrowserConfiguration.class);

    @BeforeMethod
    public void setUp() {
        open(Configuration.baseUrl);
        Configuration.browser = browserConfiguration.remoteChrome();
        login();
    }


    @Test
    public void addArticle()  {

        ArticleDetailsPage articlePage = new ArticleDetailsPage();
        $("a[href='#editor']").click();
        articlePage.editArticleTitle("Unreal article");
        articlePage.editArticleAbout("Unreal Article Description");
        articlePage.editArticleBody("Lorem ipsum dolor sit amet");
        articlePage.editArticleTag("article");
        $("form>fieldset>button").click();
        ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
        $("button[type=\"submit\"]").shouldBe(Condition.visible);

    }

    @Test (priority = 1)
    public void editArticle(){
        HomePage homePage = new HomePage();
        homePage.openProfile();
        $(By.className("preview-link")).click();
        ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
        $(By.className("ion-edit")).click();
        articleDetailsPage.editArticleBody("Unreal article_updated");
        $("form>fieldset>button").click();
    }


    @Test (priority = 2)
    public void deleteArticle(){
        HomePage homePage = new HomePage();
        homePage.openProfile();
        $(By.className("preview-link")).click();
        ArticleDetailsPage articleDetailsPage = new ArticleDetailsPage();
        $(By.className("ion-trash-a")).click();
    }



}
