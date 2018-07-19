package com.wisoft.boot.springboottutorial;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootTutorialController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello Spring Boot!";
    }
}
