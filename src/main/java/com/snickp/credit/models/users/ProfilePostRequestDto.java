package com.snickp.credit.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilePostRequestDto {

    String  title;
    String body;

}
