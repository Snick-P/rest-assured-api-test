package com.snickp.credit.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomAllureListener {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

//    Файлы .ftl взяты из репозитория Allure Framework
//    https://github.com/allure-framework/allure-java/blob/master/allure-attachments/src/main/resources/tpl/

    public static AllureRestAssured withCustomTemplates(){
        FILTER.setRequestTemplate("http-request.ftl");
        FILTER.setResponseTemplate("http-response.ftl");
        return FILTER;
    }
}
