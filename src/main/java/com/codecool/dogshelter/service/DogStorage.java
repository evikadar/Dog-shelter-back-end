package com.codecool.dogshelter.service;

import com.codecool.dogshelter.model.Shelter;
import com.codecool.dogshelter.model.dog.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
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

        if(Status.fromString(data[5]).equals(DogSize.INVALID)){
            throw new Exception("Invalid size type in file");
        }else{
            dog.setStatus(Status.fromString(data[5]));
        }

        dog.setShelter(new Shelter(data[6]));
        dog.setPhotoPath(data[7]);
        dog.setBoy(Boolean.parseBoolean(data[8]));
        dog.setNeutered(Boolean.parseBoolean(data[9]));
        dog.setBreed(Breed.INVALID);
        dog.setSize(DogSize.fromString(data[11]));
        return dog;
    }

    private DogDescription constructDogDescription(String personalityTrait, String dreamHome, String specialFeatures) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        DogStorage dogStorage = new DogStorage();
        dogStorage.generateDummyData();
    }
}
