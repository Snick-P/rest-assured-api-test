package test.auth;

import com.snickp.credit.spec.AuthSpec;
import io.restassured.http.ContentType;
import com.snickp.credit.models.auth.LoginRequestDto;
import com.snickp.credit.models.auth.LoginResponseDto;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Authentication {


    @Test
    public String accessToken(){

        LoginRequestDto authBody = new LoginRequestDto("leanne", "password");

        LoginResponseDto loginResponse = step("Authorization in system by login "+authBody.getUsernameOrEmail(),
                ()-> given(AuthSpec.set())
                .contentType(ContentType.JSON)
                .body(authBody)
                .when()
                .post("/auth/signin")
                .then()
                .statusCode(200)
                .extract().as(LoginResponseDto.class));

        return loginResponse.getAccessToken();
    }


}
