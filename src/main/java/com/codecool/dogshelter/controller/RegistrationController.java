package com.codecool.dogshelter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestParam("username") String username) {
        System.out.printf("I got here and I got a user with post method, %s%n", username);

    }

}
