package com.snickp.credit.models.auth;

import net.datafaker.Faker;

public class SingUpDataFactory {
    private static final Faker faker = new Faker();

    public static SingUpRequestDto singUpRequest() {

        return newUserData();
    }


    private static SingUpRequestDto newUserData() {
        var newSingUpRequest =
                SingUpRequestBuilder.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .username(faker.name().firstName())
                        .password(faker.internet().password())
                        .email(faker.internet().emailAddress())
                        .build();

        return newSingUpRequest;
    }


}
