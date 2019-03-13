package com.codecool.dogshelter.model.dog;

import java.util.Arrays;

public enum DogSize {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
    INVALID;

    public static DogSize fromString(String size){
        switch (size){
            case "EXTRA_SMALL": return EXTRA_SMALL;
            case "SMALL": return SMALL;
            case "MEDIUM": return MEDIUM;
            case "LARGE": return LARGE;
            case "EXTRA_LARGE": return EXTRA_LARGE;
            default:
                return INVALID;
        }
    }
}
