package com.codecool.dogshelter.model.dog;

public enum Gender {
    FEMALE("Female"),
    MALE("Male");

    private final String genderName;

    Gender(String genderName) {
        this.genderName = genderName;
    }

    public String getStringValue() {
        return genderName;
    }
}
