package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.User;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.DogDetailsForDogListPage;
import com.codecool.dogshelter.model.dog.DogDetailsForDogPage;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.UserRepository;
import com.codecool.dogshelter.service.DogFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    @GetMapping("/dogs")
    private List<DogDetailsForDogListPage> getDogs(){
        return dogRepository.getDogsForDogListPage();
    }

    @PostMapping("/dogs")
    private List<DogDetailsForDogListPage> getFilterdDogs(@RequestBody SearchParameters searchParameters) {
        return dogFilterService.getFilterDogs(searchParameters);
    }

    @GetMapping("/dog/{id}")
    private DogDetailsForDogPage getDog(@PathVariable Long id) {

        Optional<DogDetailsForDogPage> searchedDog = dogRepository.getDogDetailsForDogPageById(id);
        if (!searchedDog.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No available dog by this ID.");
        }
        return searchedDog.get();
    }
}
