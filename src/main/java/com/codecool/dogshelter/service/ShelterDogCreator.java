package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.ShelterDog;
import org.springframework.stereotype.Component;

@Component
public class ShelterDogCreator {

    public ShelterDog createRandomShelterDog() {
        ShelterDog shelterDog = new ShelterDog(Rnd.getRandomDogName(), Rnd.getNumber(15));
        shelterDog.setStatus(Rnd.getRandomStatus());
        shelterDog.setBreed(Rnd.getRandomBreed());
        return shelterDog;
    }
}
