package test.auth;

import com.snickp.credit.models.auth.SingUpDataFactory;
import com.snickp.credit.models.auth.SingUpResponseDto;
import com.snickp.credit.spec.RequestSpecification;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class SignUpTest {

// Разобрать с взаимодействием при 500 статусе и сообщении "Username is already taken"
// При успешном создании пользователя - 201

    @Test
    public void SignUpTest() {
        var signUpBody = SingUpDataFactory.singUpRequest();

        SingUpResponseDto signUpResponse = step("Sing Up new user " + signUpBody.getUsername(), () ->
                given(RequestSpecification.set())
                        .contentType(ContentType.JSON)
                        .body(signUpBody)
                        .when()
                        .post("/auth/signup")
                        .then()
                        .statusCode(201)
                        .extract().as(SingUpResponseDto.class));

        step("Check Massage", () ->
                assertThat(signUpResponse.getMessage().equals(true)));
        step("Check Success", () ->
                assertThat(signUpResponse.getSuccess().equals("User registered successfully")));

    }
}
