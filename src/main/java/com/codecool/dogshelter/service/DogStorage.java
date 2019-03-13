package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.Dog;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DogStorage {
    private List<Dog> dogs = new LinkedList<>();

    public List<Dog> getAll() {
        return dogs;
    }

    public void addRandomUser() {
        Dog randomDog = new Dog(
            Rnd.getRandomDogName(), Rnd.getNumber(11)
        );

        dogs.add(randomDog);
    }
}
