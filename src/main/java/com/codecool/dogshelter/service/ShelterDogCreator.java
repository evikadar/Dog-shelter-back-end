package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.ShelterDog;
import org.springframework.stereotype.Component;

@Component
public class ShelterDogCreator {

    public ShelterDog createShelterDog(Dog dog) {
        ShelterDog shelterDog = new ShelterDog(dog);
        return shelterDog;
    }
}
