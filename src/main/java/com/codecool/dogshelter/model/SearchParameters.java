package com.codecool.dogshelter.model;

import com.codecool.dogshelter.model.dog.Breed;
import com.codecool.dogshelter.model.dog.DogSize;
import com.codecool.dogshelter.model.dog.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SearchParameters {

    private Boolean isNeutered;
    private String age;
    private Breed breed;
    private Gender gender;
    private DogSize dogSize;
}
