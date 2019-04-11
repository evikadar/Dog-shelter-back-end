package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.dog.*;
import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.model.SearchParameters;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.ShelterRepository;
import com.codecool.dogshelter.service.DogFilterService;
import com.codecool.dogshelter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogFilterService dogFilterService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ShelterRepository shelterRepository;

    @RequestMapping("/dogs")
    @GetMapping("/dogs")
    private List<DogForDogListPage> getDogs() {
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

    @GetMapping("/dogs/shelter/{id}")
    private List<DogForDogPage> getDogsByShelterId(@PathVariable Long id){
        return dogRepository.getDogsFilteredByShelterId(id);
    }

    @PostMapping(value = "/shelter/dog")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveNewDog(
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam("shelterId") String shelterIdString,
            @RequestParam("name") String name,
            @RequestParam("breed") Breed breed,
            @RequestParam("dateOfBirth") String dateOfBirthString,
            @RequestParam("size") DogSize size,
            @RequestParam(name = "status", required = false, defaultValue = "AVAILABLE") Status status,
            @RequestParam(name = "personalityTrait", required = false) String personalityTrait,
            @RequestParam(name = "dreamHome", required = false) String dreamHome,
            @RequestParam(name = "specialFeatures", required = false) String specialFeatures,
            @RequestParam("gender") Gender gender,
            @RequestParam("isNeutered") boolean isNeutered
            ) {

        Long shelterId = Long.valueOf(shelterIdString);
        Shelter shelter = shelterRepository.getById(shelterId);
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        DogDescription dogDescription = DogDescription.builder()
                .personalityTrait(personalityTrait)
                .dreamHome(dreamHome)
                .specialFeatures(specialFeatures)
                .build();

        Dog dogToAdd = Dog.builder()
                .breed(breed)
                .shelter(shelter)
                .dateOfBirth(dateOfBirth)
                .name(name)
                .size(size)
                .status(status)
                .isNeutered(isNeutered)
                .gender(gender)
                .description(dogDescription)
                .build();

        if (file != null) {
            String fileName = fileStorageService.storeFile(file);
            dogToAdd.setPhotoPath(fileName);
        }
        dogRepository.save(dogToAdd);
    }

    @GetMapping("/dogs/enums")
    Map<String, Map<String, String>> getDogEnums() {
        Map<String, Map<String, String>> dogEnumMap = new HashMap<>();
        dogEnumMap.put("breeds", Breed.getMapOfBreeds());
        dogEnumMap.put("sizes", DogSize.getMapOfDogSizes());
        dogEnumMap.put("statuses", Status.getMapOfStatuses());
        return dogEnumMap;
    }

}
