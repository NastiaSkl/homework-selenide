package io.react.realworldapp.service;

import io.react.realworldapp.model.Article;
import io.react.realworldapp.model.ArticleResponse;
import io.restassured.RestAssured;


public class ArticleService extends ApiService {

    private String token;

    public ArticleService(String token) {
        this.token = token;

    }

    public Article createArticle(Article article) {
        return RestAssured
                .given()
                .header("Authorization", "Token " + token)
                .body(article)
                .when()
                .post("/articles")
                .then()
                .statusCode(200)
                .extract().body()
                .as(ArticleResponse.class)
                .getArticle();
    }
}
