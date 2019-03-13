package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.Util.Rnd;
import com.codecool.dogshelter.model.Person;

public class ShelterDog extends Dog {

    private Status status;
    private Person ownerCandidate;

    public ShelterDog() {

    }

    // todo: for test only, delete as soon as possible!!!
    public ShelterDog(Dog dog) {
        status = Rnd.getRandomStatus();
        setId(dog.getId());
        setBreed(dog.getBreed());
        setAge(dog.getAge());
        setName(dog.getName());
        setDescription(dog.getDescription());
        setGender(dog.getGender());
        setNeutered(dog.isNeutered());
        setPhotoPath(dog.getPhotoPath());
        setShelter(dog.getShelter());
        setSize(dog.getSize());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
