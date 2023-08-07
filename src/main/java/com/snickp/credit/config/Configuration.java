package com.snickp.credit.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:api.properties"})
public interface Configuration extends Config {

    @Key("api.base.uri")
    String baseUri();

    @Key("api.base.path")
    String basePath();

    @Key("api.base.port")
    int port();

    @Key("log.all")
    boolean logAll();

    }



