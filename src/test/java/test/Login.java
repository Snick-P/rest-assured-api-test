package test;

import io.qameta.allure.Owner;
import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static spec.LoginSpec.loginRequestSpec;
import static spec.LoginSpec.loginResponseSpec;

public class Login {

    @DisplayName("Успешная авторизация")
    @Owner("snproskuryakov")
    @Tag("signin")
    @Test
    public void loginTest() {
        LoginBodyModel loginBody = new LoginBodyModel();
        loginBody.setPassword("password");
        loginBody.setUsernameOrEmail("leanne");

        LoginResponseModel loginResponse = step("Get authorization data", () ->
                given(loginRequestSpec)
                        .body(loginBody)
                        .when()
                        .post("/auth/signin")
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponseModel.class));

        step("Verify authorization token", () ->
                assertThat(loginResponse.getAccessToken()).contains("eyJhbGciOiJIUzUxMiJ9"));

        step("Verify authorization token type", () ->
                assertThat(loginResponse.getTokenType()).isEqualTo("Bearer"));
    }
}
