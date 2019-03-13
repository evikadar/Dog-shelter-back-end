package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.ShelterDog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ShelterDogStorage {

    @Autowired
    private ShelterDogCreator shelterDogCreator;

    private List<ShelterDog> shelterDogs = new LinkedList<>();
    private static int id = 1;

    public List<ShelterDog> getAllShelterDogs() {
        return shelterDogs;
    }

    public void addRandomShelterDog() {
        ShelterDog shelterDog = shelterDogCreator.createRandomShelterDog();
        shelterDog.setId(id);
        shelterDog.setPhotoPath("http://localhost:8080/img/dog" + id + ".jpeg");
        shelterDogs.add(shelterDog);
        id++;
    }
}
