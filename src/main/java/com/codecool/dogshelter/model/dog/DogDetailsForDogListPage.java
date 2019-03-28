package com.codecool.dogshelter.model.dog;

import org.springframework.beans.factory.annotation.Value;

public interface DogDetailsForDogListPage {

    Long getId();

    String getName();

    String getPhotoPath();

    Breed getBreed();

    Gender getGender();

    @Value("#{target.getAge()}")
    Long getAge();

}
