package cz.osu.sorting;

/**
 * Whole logic of Selection sort.
 */
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
            int minimumIndex = findMinimumValue(array,i);
            swap(array, minimumIndex, i);
        }
    }

    /**
     * Finds minimum value in the array and gets its index.
     * @param array The array where the value is found.
     * @param i The index of outer loop.
     */
    private static int findMinimumValue(int[] array, int i) {
        int minimumIndex = i;

        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minimumIndex]) {
                minimumIndex = j;
            }
        }

        return minimumIndex;
    }

    /**
     * Swaps array values - the first index with second index.
     * @param array The given array where values will be swapped.
     * @param left The index of first value.
     * @param right The index of second value.
     */
    private static void swap(int[] array, int left, int right) {
        int tempValue = array[left];
        array[left] = array[right];
        array[right] = tempValue;
    }


}
