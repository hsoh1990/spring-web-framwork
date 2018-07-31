package com.wellstone.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/user")
    public Principal user(Principal principal){
	    return principal;
    }


    @RequestMapping(value = "/login")
    public Principal login(Principal principal){
        return principal;
    }

    @RequestMapping(value = "/api/test")
    public String apit(){
        return "ok";
    }
}
