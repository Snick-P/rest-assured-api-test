package com.snickp.credit.spec;

import com.snickp.credit.config.ConfigurationManager;
import com.snickp.credit.helpers.CustomAllureListener;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class InitialStateSpec {


    public static RequestSpecification set (){

       var configuration = ConfigurationManager.getConfiguration();

        return new RequestSpecBuilder()
                .setBaseUri(configuration.baseUri())
                .setBasePath(configuration.basePath())
                .setPort(configuration.port())
                .addFilter(CustomAllureListener.withCustomTemplates())
                .build();
          }
}
