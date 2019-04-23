package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean register(@RequestBody User incomingUser) {
        String user = incomingUser.getUsername();
        String password = passwordEncoder.encode(incomingUser.getPassword());

        User databaseUser = userRepository.findByUsername(user);
        if (databaseUser != null) {
            String foundName = databaseUser.getUsername();
            String foundPassword = databaseUser.getPassword();
            if (user.equals(foundName) && (password.equals(foundPassword))) {
                System.out.printf("You are in!!!!! :)%n");
                return true;
            } else {
                System.out.printf("You are out :(%n");
                return false;
            }
        } else {
            System.out.printf("No user by this name.%n");
            return false;
        }
    }

    @GetMapping(value = "/profile/{name}")
    private User getUserProfilePage(@PathVariable String name) {
        return userRepository.findByUsername(name);
    }




}
