package com.codecool.dogshelter.model.dog;

import com.codecool.dogshelter.model.Shelter;

public class Dog {

    private static int nextId;

    private int id;
    private String name;
    private int age;
    private DogDescription description;
    private Shelter shelter;
    private String photoPath;
    private Gender gender;
    private boolean isNeutered;
    private Breed breed;
    private DogSize size;

    public Dog() {
        id = nextId++;
    }

    public Dog() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DogDescription getDescription() {
        return description;
    }

    public void setDescription(DogDescription description) {
        this.description = description;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isNeutered() {
        return isNeutered;
    }

    public void setNeutered(boolean neutered) {
        isNeutered = neutered;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public DogSize getSize() {
        return size;
    }

    public void setSize(DogSize size) {
        this.size = size;
    }
}
