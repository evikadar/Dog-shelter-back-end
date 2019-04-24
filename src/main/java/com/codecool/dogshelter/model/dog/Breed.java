package com.codecool.dogshelter.model.dog;


import java.util.*;

public enum Breed {
    BEAGLE("Beagle"),
    BORDER_COLLIE("Border collie"),
    CHIHUAHUA("Chihuahua"),
    COLLIE("Collie"),
    GERMAN_SHEPHERD("German shepherd"),
    HOUND("Hound"),
    HUSKY("Husky"),
    JACK_RUSSEL("Jack russel terrier"),
    LABRADOR("Labrador"),
    MIXED("Mixed"),
    PUG("Pug"),
    REDBONE("Redbone coonhound"),
    RETRIEVER("Retriever"),
    TERRIER("Terrier");

    private final String breedName;

    Breed(String breedName) {
        this.breedName = breedName;
    }

    public String getStringValue() {
        return breedName;
    }

    public static Map<String, String> getMapOfBreeds() {
        Map<String, String> breedMap = new LinkedHashMap<>();
        Arrays.stream(Breed.values()).forEach(breed -> breedMap.put(breed.toString(), breed.getStringValue()));
        return breedMap;
    }

    public static Breed getFromStringIfValid(String breed) {
        Optional<Breed> found = Arrays.stream(values())
                .filter(b -> b.toString().equals(breed))
                .findFirst();
        return found.orElse(null);
    }
}
