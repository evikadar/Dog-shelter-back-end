package com.codecool.dogshelter.model.dog;

public enum Status {
    AVAILABLE,
    ADOPTED,
    PENDING,
    INVALID;

    public static Status fromString(String size){
        switch (size){
            case "AVAILABLE": return AVAILABLE;
            case "ADOPTED": return ADOPTED;
            case "PENDING": return PENDING;

            default:
                return INVALID;
        }
    }
}
