package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.SearchParameters;
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
            filteredDogs = filterByAge(filteredDogs, params);
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

    private List<DogForDogListPage> filterByAge(List<DogForDogListPage> dogs, SearchParameters params){
        String ageBound = params.getAge();

        if(ageBound.equals("PUPPY")){
            dogs = dogs.stream()
                    .filter(dog -> dog.getAge() <= 1)
                    .collect(Collectors.toList());

        }else if(ageBound.equals("YOUNG")){
            dogs = dogs.stream()
                    .filter(dog -> dog.getAge() > 1 && dog.getAge() <= 2)
                    .collect(Collectors.toList());

        }else if(ageBound.equals("ADULT")){
            dogs = dogs.stream()
                    .filter(dog -> dog.getAge() > 2 && dog.getAge() <= 8)
                    .collect(Collectors.toList());

        }else if(ageBound.equals("SENIOR")){
            dogs = dogs.stream()
                    .filter(dog -> dog.getAge() > 8)
                    .collect(Collectors.toList());
        }

        return dogs;
    }

}
