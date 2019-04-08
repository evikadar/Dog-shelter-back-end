package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.model.shelter.ShelterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {

    @Query("SELECT s FROM Shelter s where s.id = :shelter_id")
    List<ShelterDetails> findByShelterId(@Param("shelter_id") Long id);

    @Query("UPDATE Shelter s set s.name = :name, s.email = :email, s.phoneNumber = :phoneNumber, s.shelterDescription = :description WHERE s.id = :id")
    @Transactional
    @Modifying(clearAutomatically = true)
    void updateShelterDetailsById(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("phoneNumber") String phoneNumber,
                                  @Param("description") String shelterDescription);

    @Query("UPDATE Address a set a.country = :country, a.city = :city, a.address = :address, a.zipCode = :zipCode WHERE a.id = :id")
    @Transactional
    @Modifying(clearAutomatically = true)
    void updateAddressById(@Param("id") Long id, @Param("country") String country, @Param("city") String city, @Param("address") String address,
                                  @Param("zipCode") Integer zipCode);

}
