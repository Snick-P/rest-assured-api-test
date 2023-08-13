package test.users;


import com.snickp.credit.models.users.ProfileResponseDto;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ProfileTest {

@Test
    public void Profile (){
        String username = "leanne";

        ProfileResponseDto profileResponse = step("Get profile data", ()->
                given()
                        .get("/api/users/"+username+"/profile")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract().as(ProfileResponseDto.class)
        );

        step("Verification username",()->
                assertThat(profileResponse.getUsername().equals(username))
                );
    }



}
