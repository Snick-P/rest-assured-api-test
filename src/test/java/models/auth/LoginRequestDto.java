package models.auth;

import lombok.Data;


@Data

public class LoginRequestDto {

    String usernameOrEmail;

    String password;
}
