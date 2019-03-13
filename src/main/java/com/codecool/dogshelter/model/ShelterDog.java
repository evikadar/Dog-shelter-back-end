package com.codecool.dogshelter.model;

public class ShelterDog extends Dog {

    private Status status;
    private Person ownerCandidate;

    public ShelterDog(String name, int age) {
        super(name, age);
    }

    public ShelterDog() {

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
