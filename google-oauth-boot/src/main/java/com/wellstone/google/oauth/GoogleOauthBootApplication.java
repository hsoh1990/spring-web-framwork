package com.wellstone.google.oauth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GoogleOauthBootApplication {

    private static final String PROPERTIES = "spring.config.location=classpath:/google.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(GoogleOauthBootApplication.class)
                .properties(PROPERTIES)
                .run(args);
    }
}
