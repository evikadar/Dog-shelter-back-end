package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.dog.DogDetailsForDogListPage;
import com.codecool.dogshelter.model.dog.DogDetailsForDogPage;
import com.codecool.dogshelter.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    // TODO: Return only dogs with available status
    @GetMapping("/dogs")
    private List<DogDetailsForDogListPage> getDogs(){
        return dogRepository.getDogsForDogListPage();
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
