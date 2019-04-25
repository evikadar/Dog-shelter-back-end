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
        Shelter shelterInDb = shelterRepository.getOne(id);
        Address addressInDb = shelterInDb.getAddress();
        Address newAddress = shelter.getAddress();

        shelterInDb.setName(shelter.getName());
        shelterInDb.setEmail(shelter.getEmail());
        shelterInDb.setPhoneNumber(shelter.getPhoneNumber());
        shelterInDb.setShelterDescription(shelter.getShelterDescription());

        if (addressInDb != null){
            addressInDb.setCountry(newAddress.getCountry());
            addressInDb.setCity(newAddress.getCity());
            addressInDb.setAddress(newAddress.getAddress());
            addressInDb.setZipCode(newAddress.getZipCode());

        } else {
            shelterInDb.setAddress(newAddress);
        }

        shelterRepository.save(shelterInDb);
    }
}
