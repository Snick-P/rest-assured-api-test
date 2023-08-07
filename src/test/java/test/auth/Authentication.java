package test.auth;

import com.snickp.credit.spec.InitialStateSpec;
import io.restassured.http.ContentType;
import models.auth.LoginRequestDto;
import models.auth.LoginResponseDto;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Authentication {



    public String accessToken(){

        LoginRequestDto body = new LoginRequestDto();
        body.setUsernameOrEmail("leanne");
        body.setPassword("password");

        LoginResponseDto loginResponse = step("Authorization in system",()-> given(InitialStateSpec.set())
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/auth/signin")
                .then()
                .statusCode(200)
                .extract().as(LoginResponseDto.class));

        return loginResponse.getAccessToken();
    }


}
