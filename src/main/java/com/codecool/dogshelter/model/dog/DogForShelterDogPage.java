package com.codecool.dogshelter.model.dog;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface DogForShelterDogPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    String getBreedAsString();

    String getGenderAsString();

    Gender getGender();

    String getStatusAsString();

    Status getStatus();

    String getSizeAsString();

    DogSize getSize();

    boolean isNeutered();

    SimpleDogDescription getDescription();

    LocalDate getDateOfBirth();

    OwnerInfo getOwner();

    @Value("#{target.getAge()}")
    Long getAge();
}
