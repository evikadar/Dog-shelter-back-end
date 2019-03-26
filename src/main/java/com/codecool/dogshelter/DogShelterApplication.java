package com.codecool.dogshelter;

import com.codecool.dogshelter.model.dog.Breed;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
public class DogShelterApplication {

    @Autowired
    private DogRepository dogRepository;

    public static void main(String[] args) {
        SpringApplication.run(DogShelterApplication.class, args);
    }

    @Profile("production")
    @Bean
    public CommandLineRunner init() {
        return args -> {
            Dog bobby = Dog.builder().age(5).breed(Breed.CHIHUAHUA).name("Bobby").build();
            dogRepository.save(bobby);

        };
    }
}
