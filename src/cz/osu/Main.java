package cz.osu;

import cz.osu.sorting.*;

import java.util.Random;

public class Main {
    final static int LENGTH = 25;

    public static void main(String[] args) throws Exception {

        int[] array = new int[LENGTH];

        Random rnd = new Random();

        for (int i = 0; i < LENGTH; i++) {
            array[i] = rnd.nextInt(1000);
        }

        System.out.print("The array: " + printArray(array) + "\n");

        SelectionSort.sort(array);

        System.out.print("The sorted array (Selection sort): " + printArray(array));
    }

    private static String printArray(int[] array) {
        String report = "";

        for (int number : array) {
            report += number + "; ";
        }

        return report;
    }

}
