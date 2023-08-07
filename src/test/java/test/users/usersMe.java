package test.users;

import models.users.UsersDto;
import org.junit.jupiter.api.Test;
import test.auth.Authentication;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class usersMe {


    @Test

    public void userMe() {
       Authentication token = new Authentication();

        UsersDto userMe = step("Get user ", () -> given()
                .auth().oauth2(token.accessToken())
                .filter(withCustomTemplates())
                .get("http://localhost:8080/api/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UsersDto.class));

    }
}
