package cz.osu.sorting;

public class QuickSort {
    public static void sort(int[] array) {
        internalQuickSort(array,0,array.length-1);
    }

    private static void internalQuickSort(int[] array, int low, int high) {
        if (low < high) {
            // Gets index of current pivot
            int pivotIndex = partition(array, low, high);

            // Sorts all arrays before pivot
            internalQuickSort(array, low, pivotIndex-1);

            // Sorts all arrays after pivot
            internalQuickSort(array, pivotIndex+1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {

        // Gets pivot in the array -> should be last value in the array
        int pivot = array[high];
        int i = low;

        for (int j = low; j < high; j++) {

            // Checks if current value is lesser than current pivot -> these values must be before the pivot
            if (array[j] < pivot) {
                swap(array,i++,j);
            }
        }

        // Must swap these values to get pivot exactly in the order where it should be
        swap(array, i, high);
        return i;
    }

    /**
     * Swaps two indexes in given array.
     * @param array The given array.
     * @param leftIndex Index of left value.
     * @param rightIndex Index of right value.
     */
    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = 0;
        temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
