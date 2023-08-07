package models.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
public class LoginResponseDto {

    @JsonProperty("accessToken")
    String accessToken;

    @JsonProperty("tokenType")
    String tokenType;


}
