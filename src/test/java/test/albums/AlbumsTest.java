package test.albums;

import com.snickp.credit.models.albums.AlbumsRequestDto;
import com.snickp.credit.models.albums.AlbumsResponseDto;
import com.snickp.credit.spec.RequestSpecification;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import test.auth.AuthenticationTest;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class AlbumsTest {



    @Test
    public void addAlbum() {

        AlbumsRequestDto body = new AlbumsRequestDto("quidem molestiae enim");

        AlbumsResponseDto albumTestResponse = step("Create new album", () ->
                given(RequestSpecification.set())
                        .auth().oauth2(AuthenticationTest.token)
                        .contentType(ContentType.JSON)
                        .body(body)
                        .when()
                        .post("/albums")
                        .then()
                        .statusCode(201)
                        .extract().as(AlbumsResponseDto.class)
        );

        step("Check title", ()-> assertThat(albumTestResponse.getTitle().equals(body.getTitle())));

    }
}
