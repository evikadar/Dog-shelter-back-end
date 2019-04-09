package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.DogForDogListPage;
import com.codecool.dogshelter.model.dog.DogForDogPage;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.service.DogFilterService;
import com.codecool.dogshelter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @Autowired
    private FileStorageService fileStorageService;

    // TODO: Return only dogs with available status
    @RequestMapping("/dogs")
    @GetMapping("/dogs")
    private List<DogForDogListPage> getDogs(){
        return dogRepository.getDogsForDogListPage();
    }

    @PostMapping("/dogs")
    private List<DogForDogListPage> getFilterdDogs(@RequestBody SearchParameters searchParameters) {
        return dogFilterService.getFilterDogs(searchParameters);
    }

    @GetMapping("/dog/{id}")
    private DogForDogPage getDog(@PathVariable Long id) {

        Optional<DogForDogPage> searchedDog = dogRepository.getDogDetailsForDogPageById(id);
        if (!searchedDog.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "No available dog by this ID.");
        }
        return searchedDog.get();
    }

    @PostMapping(value = "/shelter/dog")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveNewDog(@RequestParam("file") MultipartFile file, @RequestParam("shelterId") String shelterId, @RequestParam ("name") String name, @RequestParam("breed") String breed) {
        String fileName = fileStorageService.storeFile(file);
        //dogRepository.save(dog);

    }

}
