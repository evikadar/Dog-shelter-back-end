package com.codecool.dogshelter.model.dog;

import java.util.Arrays;
import java.util.Optional;

public enum Status {
    AVAILABLE,
    ADOPTED,
    PENDING;

    public static Status getFromStringIfValid(String status) {
        Optional<Status> found = Arrays.stream(values())
                .filter(s -> s.toString().equals(status))
                .findFirst();
        return found.orElse(null);
    }
}
