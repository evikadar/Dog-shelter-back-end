package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.shelter.Address;
import com.codecool.dogshelter.model.shelter.Shelter;
import com.codecool.dogshelter.repository.ShelterRepository;
import com.codecool.dogshelter.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/")
public class ShelterController {

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("shelter/{id}/edit")
    @ResponseStatus(HttpStatus.CREATED)
    public void editShelter(
            @PathVariable ("id") Long id,
            @RequestParam(name = "file", required = false) MultipartFile file,
            @RequestParam("shelterName") String name,
            @RequestParam("shelterEmail") String email,
            @RequestParam(name = "shelterPhoneNumber", required = false) String phoneNumber,
            @RequestParam(name = "shelterAddressCountry", required = false) String country,
            @RequestParam(name = "shelterAddressCity", required = false) String city,
            @RequestParam(name = "shelterAddressAddress", required = false) String address,
            @RequestParam(name = "shelterAddressZip", required = false) String zipString,
            @RequestParam(name = "description", required = false) String description
            ){
        Shelter shelterInDb = shelterRepository.getOne(id);
        Address addressInDb = shelterInDb.getAddress();
        Integer zip = null;
        if (!zipString.equals("")){
            zip = Integer.valueOf(zipString);
        }


        shelterInDb.setName(name);
        shelterInDb.setEmail(email);
        shelterInDb.setPhoneNumber(phoneNumber);
        shelterInDb.setShelterDescription(description);

        if (addressInDb != null){
            addressInDb.setCountry(country);
            addressInDb.setCity(city);
            addressInDb.setAddress(address);
            addressInDb.setZipCode(zip);

        } else {
            Address newAddress = Address.builder().country(country).city(city).address(address).zipCode(zip).build();
            shelterInDb.setAddress(newAddress);
        }

        if (file != null){
            String fileName = fileStorageService.storeFile(file);
            shelterInDb.setPhotoPath(fileName);
        }

        shelterRepository.save(shelterInDb);
    }
}
