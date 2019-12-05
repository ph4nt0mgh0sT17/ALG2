package cz.osu;

import cz.osu.sorting.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] array = new int[2000];

        Random rnd = new Random();

        for (int i = 0; i < 2000; i++) {
            array[i] = rnd.nextInt(1000);
        }

        InsertionSort.sort(array);

        for (int value : array) {
            System.out.print(String.format("%s; ",value));
        }


    }

}
