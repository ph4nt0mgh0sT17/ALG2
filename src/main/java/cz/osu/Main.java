package cz.osu;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /*Pattern pattern = Pattern.compile("(\\d{2})(\\d{2})(\\d{2})/(\\d+)");
        Matcher mikoMatcher = pattern.matcher("990528/5973");

        // Matcher must be checked if matches then groups can be found
        if (mikoMatcher.matches()) {
            StringBuilder regexReport = new StringBuilder()
                    .append("Year: 19")
                    .append(mikoMatcher.group(1))
                    .append("; Month: ")
                    .append(mikoMatcher.group(2))
                    .append("; Day: ")
                    .append(mikoMatcher.group(3))
                    .append("; Generated code: ")
                    .append(mikoMatcher.group(4));

            System.out.println(regexReport.toString());
        }*/

        int[] arrayNumbers = new int[]{
                1,
                -1000,
                -50,
                4,
                10,
                50
        };

        selectionSort(arrayNumbers);

        for (int number : arrayNumbers) {
            System.out.println(number);
        }
    }



    private static int findMinimumIndex(int[] array, int currentIndex) {

        return internalFindMinimumIndex(array,currentIndex, currentIndex);
    }

    private static int internalFindMinimumIndex(int[] array, int currentIndex, int minimumIndex) {
        if (currentIndex < array.length - 1) {
            if (array[currentIndex + 1] < array[currentIndex]) {
                return internalFindMinimumIndex(array, currentIndex + 1, currentIndex + 1);
            }

            else {
                return internalFindMinimumIndex(array, currentIndex + 1, minimumIndex);
            }
        }

        return minimumIndex;
    }

    private static void selectionSort(int[] array) {
        internalSelectionSort(array,0);
    }

    private static void internalSelectionSort(int[] array, int currentIndex) {
        if (currentIndex < array.length - 1) {
            int minimumIndex = findMinimumIndex(array,currentIndex);
            swap(array, minimumIndex, currentIndex);

            internalSelectionSort(array, currentIndex + 1);
        }
    }

    private static void swap(int[] array, int left, int right) {
        int tempValue = array[left];
        array[left] = array[right];
        array[right] = tempValue;
    }



}

