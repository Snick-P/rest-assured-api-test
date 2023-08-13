package test.users;

import com.snickp.credit.models.users.UsersDto;
import org.junit.jupiter.api.Test;
import test.auth.AuthenticationTest;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class UsersMeTest {


    @Test
    public void userMe() {
       AuthenticationTest token = new AuthenticationTest();

        UsersDto userMe = step("Get user ", () -> given()
                .auth().oauth2( AuthenticationTest.token)
                .filter(withCustomTemplates())
                .get("http://localhost:8080/api/users/me")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UsersDto.class)
        );

    }
}
