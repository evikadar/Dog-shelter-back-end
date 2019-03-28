package com.codecool.dogshelter.model.dog;

public interface DogForShelterDogListPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    Status getStatus();

}