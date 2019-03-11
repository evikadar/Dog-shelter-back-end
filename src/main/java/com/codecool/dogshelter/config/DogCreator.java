package com.codecool.dogshelter.config;

import com.codecool.dogshelter.model.Dog;
import com.codecool.dogshelter.service.Rnd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogCreator {

    @Bean
    public Dog creator(){
        return new Dog(Rnd.randomString(), Rnd.getNumber(11));
    }
}
