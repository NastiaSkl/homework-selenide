package io.react.realworldapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class ArticleAuthor {
    @Data
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public class Author {

        @JsonProperty("username")
        private String username;
        @JsonProperty("bio")
        private String bio;
        @JsonProperty("image")
        private String image;
        @JsonProperty("following")
        private Boolean following;
    }
}
