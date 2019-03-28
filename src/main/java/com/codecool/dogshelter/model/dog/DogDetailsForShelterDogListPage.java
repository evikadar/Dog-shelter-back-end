package com.codecool.dogshelter.model.dog;

public interface DogDetailsForShelterDogListPage {

    Long getId();

    String getName();

    SimpleDogDescription getDescription();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    Status getStatus();

    interface SimpleDogDescription {

        String getPersonalityTrait();

        String getDreamHome();

        String getSpecialFeatures();

    }


}
