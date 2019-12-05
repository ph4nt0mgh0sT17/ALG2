package cz.osu.sorting;

public class InsertionSort {

    public static void sort(int[] array) {
        internalInsertionSort(array);
    }

    /**
     * Internally sorts the array using Insertion Sort algorithm.
     * @param array The array being sorted.
     */
    private static void internalInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int currentIndex = i;

            currentIndex = innerInsertionSort(array, currentIndex, currentValue);

            array[currentIndex] = currentValue;
        }
    }

    private static int innerInsertionSort(int[] array, int currentIndex, int currentValue) {

        // Gets the current value to the place where it should be in sorted array
        while (currentIndex > 0 && currentValue < array[currentIndex - 1]) {
            array[currentIndex] = array[currentIndex - 1];
            currentIndex--;
        }

        // Returns the index where the current value should be stored
        return currentIndex;
    }
}
