package com.codecool.dogshelter.model.dog;

import org.springframework.beans.factory.annotation.Value;

public interface DogForShelterDogListPage {

    Long getId();

    String getName();

    String getPhotoPath();

    @Value("#{target.getBreedAsString()}")
    String getBreed();

    @Value("#{target.getGenderAsString()}")
    String getGender();

    @Value("#{target.getStatusAsString()}")
    String getStatus();

    @Value("#{target.getSizeAsString()}")
    String getSize();

    boolean isNeutered();

    @Value("#{target.getAge()}")
    Long getAge();

}