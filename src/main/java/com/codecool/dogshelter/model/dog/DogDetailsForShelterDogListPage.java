package com.codecool.dogshelter.model.dog;

public interface DogDetailsForShelterDogListPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    Status getStatus();

}