package com.codecool.dogshelter.model.dog;

import org.springframework.beans.factory.annotation.Value;

public interface DogForShelterDogListPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    Status getStatus();

    DogSize getSize();

    boolean isNeutered();

    @Value("#{target.getAge()}")
    Long getAge();

}