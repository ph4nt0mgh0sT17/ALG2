package cz.osu.sorting;

/**
 * Whole logic of Bubble sort algorithm.
 */
public class BubbleSort {

    /**
     * Sorts given int array using Bubble Sort algorithm.
     * @param array The given integer array.
     */
    public static void sortSwap(int[] array) {
        internalSort(array);
    }

    public static void sortLastPlace(int[] array) {
        int r = array.length - 1;
        int pom, j;

        do {
            j = 0;
            for (int i = 0; i <= r-1; i++) {
                if (array[i] > array[i+1]) {
                    pom = array[i];
                    array[i] = array[i+1];
                    array[i+1] = pom;
                    j = i;
                }
            }

            r = j;
        } while(r != 0);
    }

    /**
     * Internal method for sorting using bubblesort
     * @param array The given int array.
     */
    private static void internalSort(int[] array) {
        boolean withoutSwap;
        do {
            withoutSwap = internalBubbleSortLoop(array);
        } while(!withoutSwap);
    }


    /**
     * Executes inner loop from Bubble Sort algorithm.
     * @param array The integer array.
     */
    private static boolean internalBubbleSortLoop(int[] array) {
        boolean withoutSwap = true;

        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j+1]) {
                swapArrayValues(array,j,j+1);
                withoutSwap = false;
            }
        }

        return withoutSwap;
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
