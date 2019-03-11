package com.codecool.dogshelter.controller;

import com.codecool.dogshelter.model.Dog;
import com.codecool.dogshelter.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class DogController {

    @Autowired
    private DogStorage dogStorage;

    @GetMapping("/dogs")
    private List<Dog> getUsers(){
        return dogStorage.getAll();
    }
}
