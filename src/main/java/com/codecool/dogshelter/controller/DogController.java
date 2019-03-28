package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;


    // TODO: Return only dogs with available status
    @GetMapping("/dogs")
    private List<Dog> getDogs(){
        return dogRepository.findAll();
    }

    @GetMapping("/dog/{id}")
    private Dog getDog(@PathVariable Long id) throws Exception {
        Optional<Dog> searchedDog = dogRepository.findById(id);
        if (!searchedDog.isPresent()) {
            throw new Exception("I could not find a dog by this Id.");
        }
        return searchedDog.get();
    }

}
