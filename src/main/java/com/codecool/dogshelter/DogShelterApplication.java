package com.codecool.dogshelter;

import com.codecool.dogshelter.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DogShelterApplication {

    @Autowired
    private DogStorage dogStorage;

    public static void main(String[] args) {
        SpringApplication.run(DogShelterApplication.class, args);
    }

    @PostConstruct
    private void generateRandomUsers(){
        for (int i = 0; i < 10; i++) {
            dogStorage.addRandomDog();
        }
    }

}
