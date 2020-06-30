package io.react.realworlapp.api;

import io.react.realworldapp.model.Article;
import io.react.realworldapp.model.ArticleResponse;
import io.react.realworldapp.model.User;
import io.react.realworldapp.service.UserService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ApiArticleTest {
    private UserService userService = new UserService();
    private User user;

    @BeforeClass
    public void setUp() {
        user = userService.userRegistration();
        RestAssured.baseURI = "https://conduit.productionready.io";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setAccept(ContentType.JSON)
                        .setContentType(ContentType.JSON)
                        .addHeader("Authorization", "Token " + user.getToken())
                        .log(LogDetail.ALL)
                        .build();
    }

    @Test
    public void createArticle() {
        Article article = new Article();
        article.setTitle("Article created by Nastia");
        article.setDescription("Nstia's article description");
        article.setBody("Lorem ipsum dolor sit amet");
        article.setTagList(Arrays.asList("Lorem", "ipsum"));

        Article newArticle = RestAssured
                .given()
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();

        System.out.println(newArticle);

    }

}

