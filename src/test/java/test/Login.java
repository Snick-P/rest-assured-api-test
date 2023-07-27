package test;

import io.restassured.http.ContentType;
import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Login {

    public static String baseUrl = "http://localhost:8080";


    @Test
        public void loginTest (){
        LoginBodyModel loginBody = new LoginBodyModel();
        loginBody.setPassword("password");
        loginBody.setUsernameOrEmail("leanne");

        LoginResponseModel loginResponse =
        given()
                .log().uri()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post(baseUrl + "/api/auth/signin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(LoginResponseModel.class);

        assertThat(loginResponse.getTokenType()).isEqualTo("Bearer");
        assertThat(loginResponse.getAccessToken()).contains("eyJhbGciOiJIUzUxMiJ9");


    }

}
