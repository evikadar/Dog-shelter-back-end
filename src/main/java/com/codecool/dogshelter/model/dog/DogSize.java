package com.codecool.dogshelter.model.dog;

import java.util.Arrays;
import java.util.Optional;

public enum DogSize {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
    INVALID;

    public static DogSize getFromStringIfValid(String size) {
        Optional<DogSize> found = Arrays.stream(values())
                .filter(s -> s.toString().equals(size))
                .findFirst();
        return found.orElse(null);
    }
}
