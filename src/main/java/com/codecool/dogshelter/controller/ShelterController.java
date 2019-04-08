package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.shelter.Address;
import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/")
public class ShelterController {

    @Autowired
    private ShelterRepository shelterRepository;

    @PostMapping("shelter/{id}/edit")
    public void editShelter(@PathVariable ("id") Long id, @RequestBody Shelter shelter){
        System.out.println(id);
        String name = shelter.getName();
        System.out.println(name);
        String email = shelter.getEmail();
        String phoneNumber = shelter.getPhoneNumber();
        String country = shelter.getAddress().getCountry();
        String city = shelter.getAddress().getCity();
        String address = shelter.getAddress().getAddress();
        Integer zip = shelter.getAddress().getZipCode();
        String description = shelter.getShelterDescription();

        shelterRepository.updateShelterDetailsById(id, name, email, phoneNumber, description);
        shelterRepository.updateAddressById(shelter.getAddress().getId(), country, city, address, zip);

    }
}
