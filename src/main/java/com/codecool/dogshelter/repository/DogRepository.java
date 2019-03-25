package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.dog.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
