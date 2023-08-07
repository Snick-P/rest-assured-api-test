package test.auth;

import com.snickp.credit.spec.InitialStateSpec;
import io.restassured.http.ContentType;
import models.auth.LoginRequestDto;
import models.auth.LoginResponseDto;
import org.junit.jupiter.api.Test;
import test.BaseApi;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseApi {


    @Test
    public void loginTest() {
        LoginRequestDto loginBody = new LoginRequestDto();
        loginBody.setUsernameOrEmail("leanne");
        loginBody.setPassword("password");


        LoginResponseDto loginResponse = step("Get authorization data", () ->
                given(InitialStateSpec.set())
                        .contentType(ContentType.JSON)
                        .body(loginBody)
                        .when()
                        .post("/auth/signin")
                        .then()
                        .log().all()
                        .extract().as(LoginResponseDto.class));

        step("Verify authorization token", () ->
                assertThat(loginResponse.getAccessToken()).contains("eyJhbGciOiJIUzUxMiJ9"));

        step("Verify authorization token type", () ->
                assertThat(loginResponse.getTokenType()).isEqualTo("Bearer"));

    }

}
