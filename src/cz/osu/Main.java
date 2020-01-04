package cz.osu;

import cz.osu.sorting.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] array = new int[10];

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            array[i] = rnd.nextInt(1000);
        }

        QuickSort.sort(array);

        for (int i : array) {
            System.out.print(i + "; ");
        }




    }

}
