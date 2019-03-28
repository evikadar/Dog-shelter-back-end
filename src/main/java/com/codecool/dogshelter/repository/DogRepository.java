package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.dog.Dog;
import com.codecool.dogshelter.model.dog.DogForDogListPage;
import com.codecool.dogshelter.model.dog.DogForDogPage;
import com.codecool.dogshelter.model.dog.DogForShelterDogListPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<DogForShelterDogListPage> getAllByShelter_Id(Long id);

    @Query("select d from Dog d where d.id = :dog_id and d.status = 'AVAILABLE'")
    Optional<DogForDogPage> getDogDetailsForDogPageById(@Param("dog_id") Long id);

    @Query("select d from Dog d where d.status = 'AVAILABLE'")
    List<DogForDogListPage> getDogsForDogListPage();

}
