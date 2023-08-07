package test.auth;

import com.snickp.credit.spec.InitialStateSpec;
import io.restassured.http.ContentType;
import models.auth.SingUpRequestDto;
import models.auth.SingUpResponseDto;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class SignUpTest {

// Разобрать с взаимодействием при 500 статусе и сообщении "Username is already taken"
// При успешном создании пользователя - 201

    @Test
    public void SignUpTest() {
        SingUpRequestDto signUpBody = new SingUpRequestDto();

        SingUpResponseDto signUpResponse = step("Sing Up new user " + signUpBody.getUsername(), () ->
                given(InitialStateSpec.set())
                        .contentType(ContentType.JSON)
                        .body(signUpBody)
                        .when()
                        .post("/auth/signup")
                        .then()
                        .extract().as(SingUpResponseDto.class));

    }

}
