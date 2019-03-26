package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.shelter.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Query("SELECT s FROM Shelter s where s.id = :shelter_id")
    Shelter getShelterDetailsById(@Param("shelter_id") Long id);

}
