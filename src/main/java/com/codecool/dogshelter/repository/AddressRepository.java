package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.shelter.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
