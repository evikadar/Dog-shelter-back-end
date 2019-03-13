package com.codecool.dogshelter.controller;


import com.codecool.dogshelter.model.ShelterDog;
import com.codecool.dogshelter.service.ShelterDogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ShelterIndexController {

    @Autowired
    ShelterDogStorage shelterDogStorage;

    @GetMapping("/shelter/index")
    public List<ShelterDog> shelterDogs() {
        return shelterDogStorage.getAllShelterDogs();
    }

}
