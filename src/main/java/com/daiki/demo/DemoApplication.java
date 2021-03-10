package com.daiki.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static final String API_NAME = "DAIKI REST API";
    public static final String API_VERSION = "0.0.01";
    public static final String BASE_CONTROLLER_PACKAGE = "com.daiki.demo";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
