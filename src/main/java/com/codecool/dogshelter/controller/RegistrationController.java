package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.repository.UserRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public void testReg() {
        User test = User.builder().username("Anna").email("anna@gmail.com").build();
        userRepository.save(test);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User newUser) {
        String username = newUser.getUsername();
        String email = newUser.getEmail();
        String pw1 = newUser.getPassword1();
        System.out.printf("I got this json thing: %s %s %s %n", username, email, pw1);
        User newRegistration = User.builder().username(username).email(email).password1(pw1).build();
        userRepository.save(newRegistration);


    }




}
