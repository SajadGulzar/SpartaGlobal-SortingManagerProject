package com.spartaglobal.sortManager.Model;

import java.util.Random;

public class RandomArrayGenerator {
    public static int[] getRandomArray(int arrayNumber) {
            Random rand = new Random();
            int[] randomArray = new int[arrayNumber];
            for (int i = 0; i < randomArray.length; i++) {
                randomArray[i] = rand.nextInt(10_000);
            }
            return randomArray;
        }
    }

