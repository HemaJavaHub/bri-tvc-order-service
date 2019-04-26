package com.demo.orderservice.Utils;

import java.security.SecureRandom;
import java.util.Random;

public class OrderNumberGenerator {

    static final private String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static final private Random rng = new SecureRandom();

    static char randomChar(){
        return ALPHABET.charAt(rng.nextInt(ALPHABET.length()));
    }

    public static String randomOrderNumber(){
        int length=16;
        int spacing = 3;
        char spacerChar= '-';

        StringBuilder sb = new StringBuilder();
        int spacer = 0;
        while(length > 0){
            if(spacer == spacing){
                sb.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            sb.append(randomChar());
        }
        return sb.toString();
    }
}
