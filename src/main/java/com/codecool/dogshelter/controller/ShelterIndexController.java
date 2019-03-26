package com.codecool.dogshelter.controller;


import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.SimpleDog;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ShelterIndexController {

    @Autowired
    ShelterRepository shelterRepository;

    @Autowired
    DogRepository dogRepository;

    @GetMapping("/shelter/{id}/dogs")
    private List<SimpleDog> shelterDogs() {
        // TODO: write query for this to return dogs of certain shelters
        return dogRepository.getAllByShelter_Id(1L);
    }
}
