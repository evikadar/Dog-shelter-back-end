package com.codecool.dogshelter.service;

import com.codecool.dogshelter.controller.SearchParameters;
import com.codecool.dogshelter.model.dog.DogForDogListPage;
import com.codecool.dogshelter.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogFilterService {

    @Autowired
    private DogRepository dogRepository;

    public List<DogForDogListPage> getFilterDogs(SearchParameters params) {
        List<DogForDogListPage> filteredDogs = dogRepository.getDogsForDogListPage();

        if (params.getIsNeutered() != null) {
            filteredDogs = filteredDogs.stream()
                    .filter(dog -> dog.isNeutered() == params.getIsNeutered())
                    .collect(Collectors.toList());
        }

        if (params.getAge() != null) {
            filteredDogs = filteredDogs.stream()
                    .filter(dog -> dog.getAge() == params.getAge())
                    .collect(Collectors.toList());
        }

        if (params.getBreed() != null) {
            filteredDogs = filteredDogs.stream()
                    .filter(dog -> dog.getBreed() == params.getBreed())
                    .collect(Collectors.toList());
        }

        if (params.getGender() != null) {
            filteredDogs = filteredDogs.stream()
                    .filter(dog -> dog.getGender() == params.getGender())
                    .collect(Collectors.toList());
        }

        if (params.getDogSize() != null) {
            filteredDogs = filteredDogs.stream()
                    .filter(dog -> dog.getSize() == params.getDogSize())
                    .collect(Collectors.toList());
        }

        return filteredDogs;
    }

}
