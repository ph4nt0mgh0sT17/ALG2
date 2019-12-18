package cz.osu.sorting;

public class QuickSort {
    public static void sort(int[] array) {
        internalQuickSort(array,0,array.length-1);
    }

    private static void internalQuickSort(int[] array, int low, int high) {
        int pivot;

        if (high > low) {
            pivot = partition(array,low,high);
            internalQuickSort(array,low,pivot - 1);
            internalQuickSort(array,pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int left, right, pivotItem = array[low];
        left = low;
        right = high;

        while (left < right) {
            while (array[left] <= pivotItem) {
                left++;
                if (left == array.length) {
                    break;
                }
            }

            while (array[right] > pivotItem) {
                right--;
                if (right < 0) {
                    break;
                }
            }

            if (left < right)
                swap(array,left,right);
        }

        array[low] = array[right];
        array[right] = pivotItem;

        return right;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = 0;
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
