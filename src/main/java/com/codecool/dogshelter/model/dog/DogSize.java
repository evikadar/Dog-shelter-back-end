package com.codecool.dogshelter.model.dog;

import java.util.*;

public enum DogSize {
    EXTRA_SMALL("Extra small"),
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large"),
    EXTRA_LARGE("Extra large");

    private String sizeName;

    DogSize(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getStringValue() {
        return sizeName;
    }

    public static DogSize getFromStringIfValid(String size) {
        Optional<DogSize> found = Arrays.stream(values())
                .filter(s -> s.toString().equals(size))
                .findFirst();
        return found.orElse(null);
    }

    public static Map<String, String> getMapOfDogSizes() {
        Map<String, String> dogSizeMap = new LinkedHashMap<>();
        Arrays.stream(DogSize.values()).forEach(size -> dogSizeMap.put(size.toString(), size.getStringValue()));
        return dogSizeMap;
    }
}
