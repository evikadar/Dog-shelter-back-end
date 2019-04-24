package com.codecool.dogshelter.model.dog;

import java.time.LocalDate;

public interface DogForShelterDogPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    Status getStatus();

    DogSize getSize();

    boolean isNeutered();

    SimpleDogDescription getDescription();

    LocalDate getDateOfBirth();

    OwnerInfo getOwner();
}
