package com.snickp.credit.models.users;

import lombok.Data;

@Data
public class ProfileResponseDto {

    String id;
    String username;
    String firstName;
    String lastName;
    String joinedAt;
    String email;
    String address;
    String phone;
    String website;
    String company;
    String postCount;

}
