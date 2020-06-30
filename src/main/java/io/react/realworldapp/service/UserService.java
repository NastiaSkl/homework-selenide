package io.react.realworldapp.service;

import io.react.realworldapp.model.User;
import io.react.realworldapp.model.UserData;
import io.react.realworldapp.model.UserResponse;
import io.restassured.RestAssured;


public class UserService extends ApiService {

    public User userRegistration() {
        User user = UserData.randomUser();
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);

        User newUser = RestAssured
                .given()
                .body(userResponse)
                .when()
                .post("/users")
                .then()
                .statusCode(200)
                .extract().body()
                .as(UserResponse.class)
                .getUser();

        newUser.setPassword(user.getPassword());
        return newUser;
    }

}
