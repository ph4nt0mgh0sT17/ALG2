package cz.osu.sorting;

public class SelectionSort {
    public static void sort(int[] array) {
        internalSelectionSort(array);
    }
    
    private static void internalSelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minimumIndex = i;

            // Finds the minimum value in the array
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            // Swaps found minimum value with value at index i.
            int tempValue = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = tempValue;
        }
    }
}
