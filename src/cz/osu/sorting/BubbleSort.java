package cz.osu.sorting;

import javax.swing.*;

public class BubbleSort {
    public static void sort(int[] array) {
        internalSort(array);
    }

    private static void internalSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            internalBubbleSortLoop(array,i);
        }
    }

    private static void internalBubbleSortLoop(int[] array, int currentIndex) {
        for (int j = 0; j < array.length - currentIndex - 1; j++) {
            if (array[j] > array[j+1]) {
                int tempValue = array[j];
                array[j] = array[j+1];
                array[j+1] = tempValue;
            }
        }
    }
}
