package com.codecool.dogshelter.service;

import com.codecool.dogshelter.Util.Rnd;
import com.codecool.dogshelter.model.dog.Breed;
import com.codecool.dogshelter.model.Shelter;
import com.codecool.dogshelter.model.dog.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Service
public class DogStorage {
    private List<Dog> dogs = new LinkedList<>();

    public List<Dog> getAll() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public void generateDummyData() throws Exception {
        Scanner sc = new Scanner(new File("src/main/java/com/codecool/dogshelter/Util/dummy_data.txt"));

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Dog dog = constructDog(line);
            dogs.add(dog);
        }

    }

    private Dog constructDog(String line) throws Exception {
        String[] data = line.split(",");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].trim();
        }

        Dog dog = new Dog();
        dog.setName(data[0]);
        dog.setAge(Integer.parseInt(data[1]));
        dog.setDescription(
                constructDogDescription(data[2],data[3],data[4]
                ));
        dog.setShelter(new Shelter(data[5]));
        dog.setPhotoPath(data[6]);
        dog.setGender(Rnd.getRandomGender());
        dog.setNeutered(Boolean.parseBoolean(data[7]));
        if(Breed.getFromStringIfValid(data[8]) == null){
            throw new Exception("Invalid breed in file");
        }else{
            dog.setBreed(Breed.getFromStringIfValid(data[8]));
        }

        if(DogSize.getFromStringIfValid(data[9]) == null){
            throw new Exception("Invalid size in file");
        }else{
            dog.setSize(DogSize.getFromStringIfValid(data[9]));
        }
        return dog;
    }

    private DogDescription constructDogDescription(String personalityTrait, String dreamHome, String specialFeatures) {
        DogDescription description = new DogDescription();
        description.setPersonalityTrait(personalityTrait);
        description.setDreamHome(dreamHome);
        description.setSpecialFeatures(specialFeatures);
        return description;
    }

    public static void main(String[] args) throws Exception {
        DogStorage dogStorage = new DogStorage();
        dogStorage.generateDummyData();
    }

    public Dog getDogById(int id) throws Exception {
        return dogs.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(() -> new Exception("Dog not found"));
    }
}
