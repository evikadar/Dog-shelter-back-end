package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User newUser) {
        // TODO: PUT THIS INTO FUNCTION UNDER USER
        // TODO: HASH THEM BEFORE SAVE
        String username = newUser.getUsername();
        String email = newUser.getEmail();
        String pw1 = passwordEncoder.encode(newUser.getPassword1());
        User newRegistration = User.builder().username(username).email(email).password1(pw1).build();
        userRepository.save(newRegistration);
        System.out.printf("Registered: %s %s %s %n", username, email, pw1);

    }




}
