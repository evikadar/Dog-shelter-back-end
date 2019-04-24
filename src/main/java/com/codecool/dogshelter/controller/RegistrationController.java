package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.UserRole;
import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.repository.ShelterRepository;
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

    @Autowired
    private ShelterRepository shelterRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User newUser) {
        // TODO: PUT THIS INTO FUNCTION UNDER USER
        String username = newUser.getUsername();
        String email = newUser.getEmail();
        String pw1 = passwordEncoder.encode(newUser.getPassword1());
        String regAs = newUser.getSelectedO();
        UserRole userRole = regAs.equals("asOwner")? UserRole.POTENTIAL_PET_OWNER : UserRole.SHELTER;

        Shelter possibleShelter = userRole.equals(UserRole.SHELTER) ? (Shelter.builder()
                .name(username)
                .email(email)
                .build()) : null;

        User newRegistration = User.builder()
                .username(username)
                .email(email)
                .password1(pw1)
                .userRole(userRole)
                .shelter(possibleShelter)
                .build();

        userRepository.save(newRegistration);
        System.out.printf("%s%n", newRegistration.toString());
    }




}
