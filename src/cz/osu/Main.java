package cz.osu;

import cz.osu.sorting.SelectionSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] array = new int[10];

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            array[i] = rnd.nextInt(100);
        }

        SelectionSort.sort(array);

        for (int value : array) {
            System.out.print(String.format("%s; ",value));
        }


    }

}
