package com.codecool.dogshelter;

import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.service.DogStorage;
import com.codecool.dogshelter.service.ShelterDogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;


@SpringBootApplication
public class DogShelterApplication {

    @Autowired
    private DogStorage dogStorage;

    @Autowired
    private ShelterDogStorage shelterDogStorage;

    public static void main(String[] args) {
        SpringApplication.run(DogShelterApplication.class, args);
    }

    @PostConstruct
    private void initData() throws Exception {
        dogStorage.generateDummyData();
        shelterDogStorage.generateShelterDogs();
    }

}
