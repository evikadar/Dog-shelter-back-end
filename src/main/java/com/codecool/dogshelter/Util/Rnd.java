package com.codecool.dogshelter.Util;

import java.nio.charset.Charset;
import java.util.Random;

public class Rnd {
    private static Random random = new Random();


    public static String getString(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
    public static int getNumber(int upperbound){
        return random.nextInt(upperbound);
    }
}
