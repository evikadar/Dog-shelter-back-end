package com.codecool.dogshelter.service;

import com.codecool.dogshelter.controller.SearchParameters;
import com.codecool.dogshelter.model.dog.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogFilterServiceTest {

    @Autowired
    private DogFilterService dogFilterService;

    @Test
    public void breedMatches() {
        SearchParameters parameters = SearchParameters.builder()
                .breed(Breed.COLLIE)
                .build();

        List<DogDetailsForDogListPage> filterDogs = dogFilterService.getFilterDogs(parameters);
        assertThat(filterDogs).hasSize(2);
    }

    @Test
    public void breedNotPresent() {
        SearchParameters parameters = SearchParameters.builder()
                .isNeutered(true)
                .build();

        List<DogDetailsForDogListPage> filterDogs = dogFilterService.getFilterDogs(parameters);
        assertThat(filterDogs).hasSize(3);
        assertThat(filterDogs.get(0).isNeutered()).isEqualTo(true);
    }

    @Test
    public void moreParamIsPresent() {
        SearchParameters parameters = SearchParameters.builder()
                .isNeutered(false)
                .breed(Breed.COLLIE)
                .dogSize(DogSize.LARGE)
                .gender(Gender.MALE)
                .build();

        List<DogDetailsForDogListPage> filterDogs = dogFilterService.getFilterDogs(parameters);
        assertThat(filterDogs).hasSize(1);
        assertThat(filterDogs.get(0).getName()).isEqualTo("Bob");
    }
}