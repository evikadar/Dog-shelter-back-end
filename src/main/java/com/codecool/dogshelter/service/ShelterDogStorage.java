package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.dog.ShelterDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ShelterDogStorage {

    @Autowired
    private ShelterDogCreator shelterDogCreator;

    @Autowired
    private DogStorage dogStorage;

    private List<ShelterDog> shelterDogs = new LinkedList<>();

    public List<ShelterDog> getAllShelterDogs() {
        return shelterDogs;
    }

    public void generateShelterDogs() {
        dogStorage.getAll().forEach(dog -> shelterDogs.add(shelterDogCreator.createShelterDog(dog)));
    }
}
