package com.codecool.dogshelter;

import com.codecool.dogshelter.model.shelter.Address;
import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.model.dog.Breed;
import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.repository.AddressRepository;
import com.codecool.dogshelter.repository.DogRepository;
import com.codecool.dogshelter.repository.ShelterRepository;
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

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(DogShelterApplication.class, args);
    }

    @Profile("production")
    @Bean
    public CommandLineRunner init() {
        return args -> {
            //Dog bobby = Dog.builder().age(5).breed(Breed.CHIHUAHUA).name("Bobby").build();

            //Address noe_address = Address.builder().country("Hungary").city("Budapest").address("Csordakút út 23.")
            //        .zipCode(1171).build();

            Shelter noe = Shelter.builder().email("noe@gmail.com").phoneNumber("555-7777").name("Noé Állatotthon")
                    //.address(noe_address).dog(bobby)
                    .build();


            //bobby.setShelter(noe);
            shelterRepository.save(noe);

        };
    }

}
