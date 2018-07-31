package com.wellstone.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class SpringSecurityOauthResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthResourceApplication.class, args);
	}

    @RequestMapping(value = "/login")
    public Principal login(Principal principal){
        return principal;
    }

    @RequestMapping(value = "/api/test")
    public String apiTest(){
        return "token ok!";
    }
}
