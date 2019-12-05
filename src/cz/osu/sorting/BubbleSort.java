package cz.osu.sorting;

public class BubbleSort {

    /**
     * Sorts given int array using Bubble Sort algorithm.
     * @param array The given integer array.
     */
    public static void sort(int[] array) {
        internalSort(array);
    }

    /**
     * Internal method for sorting using bubblesort
     * @param array The given int array.
     */
    private static void internalSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            internalBubbleSortLoop(array,i);
        }
    }

    /**
     * Executes inner loop from Bubble Sort algorithm.
     * @param array The integer array.
     * @param currentIndex Current index from outer array.
     */
    private static void internalBubbleSortLoop(int[] array, int currentIndex) {
        for (int j = 0; j < array.length - currentIndex - 1; j++) {
            if (array[j] > array[j+1]) {
                swapArrayValues(array,j,j+1);
            }
        }
    }

    /**
     * Swaps array values - First index with second index.
     * @param array The given array where values will be swapped.
     * @param firstIndex The index of first value.
     * @param secondIndex The index of second value.
     */
    private static void swapArrayValues(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}
