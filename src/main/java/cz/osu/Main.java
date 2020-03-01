package cz.osu;

import cz.osu.sorting.*;

import java.util.Random;

public class Main {
    final static int LENGTH = 1000000;

    public static void main(String[] args) {

        int[] array = new int[LENGTH];

        Random rnd = new Random();

        for (int i = 0; i < LENGTH; i++) {
            array[i] = rnd.nextInt(1000);
        }

        int[] tempArray;



        System.out.print("The array: " + printArray(array) + "\n");

        System.out.println("sort");
        //tempArray = createArray(array);

        measureTime4(array);

        /*System.out.println("\nBubble sort with recent position:");

        tempArray = createArray(array);

        measureTime1(tempArray);

        System.out.println("\nSelection sort");

        tempArray = createArray(array);

        measureTime2(tempArray);

        System.out.println("\nInsertion sort");

        tempArray = createArray(array);

        measureTime4(tempArray);

        System.out.println("\nQuick sort");

        tempArray = createArray(array);

        measureTime3(tempArray);*/


    }

    private static int[] createArray(int[] array) {
        int[] newArray = new int[array.length];

        System.arraycopy(array, 0, newArray, 0, array.length);

        return newArray;
    }

    private static void measureTime(int[] array) {
        long startTime = System.nanoTime();

        BubbleSort.sortSwap(array);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("milliseconds:" + timeElapsed/1000000);
    }

    private static void measureTime1(int[] array) {
        long startTime = System.nanoTime();

        BubbleSort.sortLastPlace(array);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("milliseconds:" + timeElapsed/1000000);
    }


    private static void measureTime2(int[] array) {
        long startTime = System.nanoTime();

        SelectionSort.sort(array);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("milliseconds:" + timeElapsed/1000000);
    }

    private static void measureTime3(int[] array) {
        long startTime = System.nanoTime();

        QuickSort.sort(array);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("milliseconds:" + timeElapsed/1000000);
    }

    private static void measureTime4(int[] array) {
        long startTime = System.nanoTime();

        InsertionSort.sort(array);

        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("milliseconds:" + timeElapsed/1000000);
    }

    private static String printArray(int[] array) {
        StringBuilder report = new StringBuilder();

        for (int number : array) {
            report
              .append(number)
              .append("; ");
        }

        return report.toString();
    }

}
