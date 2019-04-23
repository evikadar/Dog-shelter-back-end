package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.PublicUserData;
import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.UserRole;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public PublicUserData register(@RequestBody User userToLogin) {
        String user = userToLogin.getUsername();
        String password = userToLogin.getPassword1();

        User triesToLogin = userRepository.findByUsername(user);
        if (triesToLogin != null) {
            String foundName = triesToLogin.getUsername();
            String foundPassword = triesToLogin.getPassword1();
            if (user.equals(foundName) && (password.equals(foundPassword))) {
                System.out.printf("You are in!!!!! :)%n");
                UserRole userRole = triesToLogin.getUserRole();
                PublicUserData toReturn = PublicUserData.builder()
                        .username(foundName).loggedIn(true).userRole(userRole).build();
                return toReturn;
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
