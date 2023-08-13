package test.auth;

import com.snickp.credit.models.auth.LoginRequestDto;
import com.snickp.credit.models.auth.LoginResponseDto;
import com.snickp.credit.spec.RequestSpecification;
import io.restassured.http.ContentType;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class AuthenticationTest {
    @Getter
 public static String token;

    @Test
    public static void accessToken(){

        LoginRequestDto authBody = new LoginRequestDto("leanne", "password");

        LoginResponseDto loginResponse = step("Authorization in system by login "+authBody.getUsernameOrEmail(),
                ()-> given(RequestSpecification.set())
                .contentType(ContentType.JSON)
                .body(authBody)
                .when()
                .post("/auth/signin")
                .then()
                .statusCode(200)
                .extract().as(LoginResponseDto.class));
            token = loginResponse.getAccessToken();
           }


}
