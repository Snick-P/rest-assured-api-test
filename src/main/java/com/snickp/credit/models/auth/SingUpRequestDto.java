package com.snickp.credit.models.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
public class SingUpRequestDto {

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;

    @JsonProperty("email")
    String email;
}
