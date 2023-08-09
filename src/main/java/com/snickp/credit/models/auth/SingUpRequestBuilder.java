package com.snickp.credit.models.auth;

import lombok.Builder;
import lombok.Getter;

@Getter

@Builder
public class SingUpRequestBuilder extends SingUpRequestDto {

    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String email;


}
