package test;

import com.snickp.credit.config.Configuration;
import com.snickp.credit.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import static io.restassured.RestAssured.*;

public abstract class BaseApi {

    protected static Configuration configuration;


    public static void beforeAllTests() {

        configuration = ConfigurationManager.getConfiguration();

        baseURI = configuration.baseUri();
        basePath = configuration.basePath();
        port = configuration.port();

        logConfig();


    }


//    Метод предназначен для настройки логирования, в зависимости от параметра logAll в
//    файле api.properties, request и response будут добавлены в лог всегда (true) или в случае
//    падения тестов (false).

    private static void logConfig() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        } else {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}

}
