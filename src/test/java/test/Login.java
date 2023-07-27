package test;

import helpers.CustomAllureListener;
import io.restassured.http.ContentType;
import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Login {

    public static String baseUrl = "http://localhost:8080";



    @Test
        public void loginTest (){
        LoginBodyModel loginBody = new LoginBodyModel();
        loginBody.setPassword("password");
        loginBody.setUsernameOrEmail("leanne");


        LoginResponseModel loginResponse = step ("Get authorization data", ()->
        given()
                .filter(CustomAllureListener.withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post(baseUrl + "/api/auth/signin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(LoginResponseModel.class));

        step("Verify authorization token", ()->
        assertThat(loginResponse.getAccessToken()).contains("eyJhbGciOiJIUzUxMiJ9"));

        step ("Verify authorization token type",()->
            assertThat(loginResponse.getTokenType()).isEqualTo("Bearer"));



    }

}
