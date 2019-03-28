package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.UserRepository;
import com.codecool.dogshelter.service.DogFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogFilterService dogFilterService;

    // TODO: Return only dogs with available status
    @RequestMapping("/dogs")
    @GetMapping("/dogs")
    private List<Dog> getDogs(){
        return dogRepository.findAll();
    }

    @PostMapping("/dogs")
    private List<Dog> getFilterdDogs(@RequestBody SearchParameters searchParameters) {
        return dogFilterService.getFilterDogs(searchParameters);
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
