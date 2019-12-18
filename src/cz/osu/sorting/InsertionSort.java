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

            innerInsertionSort(array, currentIndex, currentValue);
        }
    }

    /**
     * Moves currentValue to the place where it is as value in the right place
     * @param array The array.
     * @param currentIndex Current index of our value.
     * @param currentValue Our value.
     */
    private static void innerInsertionSort(int[] array, int currentIndex, int currentValue) {

        // Moves current value to the most left place in the array so it is ordered
        // Checks if current value is lesser than previous value so I can swap these values, if not while loop will end
        while (currentIndex > 0 && currentValue < array[currentIndex - 1]) {
            array[currentIndex] = array[currentIndex - 1];
            array[currentIndex-1] = currentValue;
            currentIndex--;

        }
    }
}
