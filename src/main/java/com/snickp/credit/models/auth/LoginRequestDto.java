package com.snickp.credit.models.auth;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginRequestDto {

    String usernameOrEmail;

    String password;
}
