package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.shelter.ShelterMinimalInfo;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface DogForDogPage {

    Long getId();

    String getName();

    SimpleDogDescription getDescription();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    ShelterMinimalInfo getShelter();

    boolean isNeutered();

    DogSize getSize();

    LocalDate getDateOfBirth();

    @Value("#{target.getAge()}")
    Long getAge();

}
