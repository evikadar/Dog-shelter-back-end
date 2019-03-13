package com.codecool.dogshelter.model.dog;


import java.util.Arrays;
import java.util.Optional;

public enum Breed {
    COLLIE,
    HUSKY,
    LABRADOR,
    RETRIEVER,
    MIXED,
    HOUND,
    PUG,
    CHIHUAHUA,
    BEAGLE,
    JACK_RUSSEL,
    GERMAN_SHEPHERD,
    BORDER_COLLIE,
    REDBONE,
    TERRIER;


    public static Breed getFromStringIfValid(String breed) {
        Optional<Breed> found = Arrays.stream(values())
                .filter(b -> b.toString().equals(breed))
                .findFirst();
        return found.orElse(null);
    }
}

