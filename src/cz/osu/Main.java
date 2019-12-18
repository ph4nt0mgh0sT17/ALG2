package cz.osu;

import cz.osu.sorting.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] array = new int[100];

        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            array[i] = rnd.nextInt(1000);
        }

        //QuickSort.sort(array);

        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }

        for (int value : array) {
            System.out.print(String.format("%s; ",value));
        }


    }

}
