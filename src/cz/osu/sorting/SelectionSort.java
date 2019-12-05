package cz.osu.sorting;

public class SelectionSort {

    /**
     * Sorts the array using Selection Sort.
     * @param array The array that is being sorted.
     */
    public static void sort(int[] array) {
        internalSelectionSort(array);
    }

    /**
     * Sorts the array internally by using Selection Sort algorithm.
     * @param array The array that is being sorted.
     */
    private static void internalSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;

            minimumIndex = findMinimumValue(array,i,minimumIndex);

            swapArrayValues(array, minimumIndex, i);
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

    /**
     * Finds minimum value in the array and gets its index.
     * @param array The array where the value is found.
     * @param i The index of outer loop.
     * @param minimumIndex The minimum index to indicate where the minimum value is.
     */
    private static int findMinimumValue(int[] array, int i, int minimumIndex) {
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minimumIndex]) {
                minimumIndex = j;
            }
        }

        return minimumIndex;
    }
}
