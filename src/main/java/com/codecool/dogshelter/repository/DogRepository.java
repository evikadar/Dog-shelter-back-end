package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.DogDetailsForShelterDogListPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<DogDetailsForShelterDogListPage> getAllByShelter_Id(Long id);

}
