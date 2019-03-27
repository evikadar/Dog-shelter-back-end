package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.model.shelter.ShelterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Query("SELECT s FROM Shelter s where s.id = :shelter_id")
    List<ShelterDetails> findByShelterId(@Param("shelter_id") Long id);

    //@Query("SELECT s FROM Shelter s where s.id = :shelter_id")
    //Shelter getShelterDetailsById(@Param("shelter_id")Long id);

}
