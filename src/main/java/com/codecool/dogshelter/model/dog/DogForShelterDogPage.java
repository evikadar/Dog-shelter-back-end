package com.codecool.dogshelter.model.dog;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface DogForShelterDogPage {

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

    SimpleDogDescription getDescription();

    LocalDate getDateOfBirth();

    OwnerInfo getOwner();

    @Value("#{target.getAge()}")
    Long getAge();
}
