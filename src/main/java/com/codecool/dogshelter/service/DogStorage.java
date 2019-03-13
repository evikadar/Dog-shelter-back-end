package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.Dog;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DogStorage {
    private static int id = 1;
    private List<Dog> dogs = new LinkedList<>();
    public List<Dog> getAll() {
        return dogs;
    }

    public void addRandomUser() {
        Dog randomDog = new Dog(
            Rnd.getRandomDogName(), Rnd.getNumber(11)
        );
        randomDog.setBreed(Rnd.getRandomBreed());
        randomDog.setId(id);
        randomDog.setPhotoPath("http://localhost:8080/img/dog" + id + ".jpeg");
        dogs.add(randomDog);
        id++;
    }
}
