package com.codecool.dogshelter.Util;

import com.codecool.dogshelter.model.dog.Breed;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Rnd {
    private static Random random = new Random();
    private static List<String> names = Arrays.asList(
            "Berci", "Folti", "Süti", "Dió", "Jocó", "Misi", "Fifi",
            "Bogyó", "Penny", "Gofri", "Maki", "Goldie", "Berke");



    public static String getString(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
    public static int getNumber(int upperbound){
        return random.nextInt(upperbound);
    }

    public static String getRandomDogName() {
        return names.get(random.nextInt(names.size()));
    }

    public static Breed getRandomBreed() {
        return Breed.values()[random.nextInt(Breed.values().length)];
    }
}
