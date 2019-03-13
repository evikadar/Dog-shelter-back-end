package com.codecool.dogshelter.model.dog;


import java.util.Arrays;
import java.util.Optional;

public enum Breed {
    COLLIE("collie"),
    HUSKY("husky"),
    LABRADOR("labrador"),
    RETRIEVER("retriever"),
    MIXED("mixed"),
    HOUND("hound"),
    PUG("pug"),
    CHIHUAHUA("chihuahua"),
    BEAGLE("beagle"),
    JACK_RUSSEL("jack russel terrier"),
    GERMAN_SHEPHERD("german shepherd"),
    BORDER_COLLIE("border collie"),
    REDBONE("redbone coonhound"),
    TERRIER("terrier");

    private final String breedName;

    Breed(String breedName) {
        this.breedName = breedName;
    }

    @Override
    public String toString() {
        return breedName;
    }

    public static Breed getFromStringIfValid(String breed) {
        Optional<Breed> found = Arrays.stream(values())
                .filter(b -> b.toString().equals(breed))
                .findFirst();
        return found.orElse(null);
    }
}
