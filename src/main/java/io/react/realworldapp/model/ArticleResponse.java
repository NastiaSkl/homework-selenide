package io.react.realworldapp.model;

import lombok.Data;


    @Data
    public class ArticleResponse {

        private Article article;

        public Article getArticle() {
            return article;
        }
}
