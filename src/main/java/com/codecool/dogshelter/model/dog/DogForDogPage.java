package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.shelter.ShelterMinimalInfo;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface DogForDogPage {

    Long getId();

    String getName();

    SimpleDogDescription getDescription();

    String getPhotoPath();

    @Value("#{target.getBreedAsString()}")
    String getBreed();

    @Value("#{target.getGenderAsString()}")
    String getGender();

    ShelterMinimalInfo getShelter();

    boolean isNeutered();

    @Value("#{target.getSizeAsString()}")
    String getSize();

    LocalDate getDateOfBirth();

    @Value("#{target.getAge()}")
    Long getAge();

}
