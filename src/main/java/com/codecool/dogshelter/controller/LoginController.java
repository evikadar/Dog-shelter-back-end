package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
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
    public String register(@RequestBody User userToLogin, RedirectAttributes redirectAttributes) {
        String user = userToLogin.getUsername();
        String password = userToLogin.getPassword1();
        System.out.printf("Data I got: %s %s %n", user, password);

        User triesToLogin = userRepository.findByUsername(user);
        String foundName = triesToLogin.getUsername();
        String foundPassword = triesToLogin.getPassword1();
        System.out.printf("In the db I have %s and pw %s%n", foundName, foundPassword);

        if (user.equals(foundName) && (password.equals(foundPassword))) {
            System.out.printf("You are in!!!!! :)%n");
            return "redirect:/dogs";
        } else {
            System.out.printf("You are out :(%n");
            redirectAttributes.addAttribute("user", user);
            redirectAttributes.addFlashAttribute("loggedIn", true);
            return "redirect:/register";
        }

    }



}
