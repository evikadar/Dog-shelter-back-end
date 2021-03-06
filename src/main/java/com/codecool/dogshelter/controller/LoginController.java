package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.PublicUserData;
import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.UserRole;
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
    public PublicUserData register(@RequestBody User incomingUser) {
        String user = incomingUser.getUsername();
        String password = incomingUser.getPassword1();
        String shelterId = "";

        User databaseUser = userRepository.findByUsername(user);
        if (databaseUser != null) {
            if (databaseUser.getShelter() != null) {
                shelterId = databaseUser.getShelter().getId().toString();
            }
            String foundName = databaseUser.getUsername();
            String foundPassword = databaseUser.getPassword1();
            if (user.equals(foundName) && (passwordEncoder.matches(password, foundPassword))) {
                System.out.printf("You are in!!!!! :)%n");
                UserRole userRole = databaseUser.getUserRole();
                PublicUserData toSend = PublicUserData.builder()
                        .username(foundName)
                        .loggedIn(true)
                        .userRole(userRole)
                        .shelterId(shelterId)
                        .build();
                return toSend;
            } else {
                System.out.printf("You are out :(%n");
                return null;
            }
        } else {
            System.out.printf("No user by this name.%n");
            return null;
        }
    }

    @GetMapping(value = "/profile/{name}")
    private User getUserProfilePage(@PathVariable String name) {
        return userRepository.findByUsername(name);
    }

}
