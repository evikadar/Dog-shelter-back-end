package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
