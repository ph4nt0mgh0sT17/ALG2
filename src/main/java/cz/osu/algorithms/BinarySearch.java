package cz.osu.algorithms;

/**
 * Algorithms for searching the value in given SORTED array.
 */
public class BinarySearch {

    /**
     * Searches the value in given array. If not found returns -1
     * @param array The given array where to search for the value
     * @param value The value to be found
     * @return The index of the value in the array.
     */
    public static int binarySearch(int[] array, int value) {
        return internalBinarySearch(array,value, 0, array.length-1);
    }

    /**
     * Recursive method for binary searching
     * @param array The given array where to search for the value
     * @param value The value to be found
     * @param startIndex The start index of the array where is the value
     * @param endIndex The end index of the array where is the value
     * @return The index of the value.
     */
    private static int internalBinarySearch(int[] array, int value, int startIndex, int endIndex) {

        // If end index of the array is still bigger or equal to start index it means the value can still be found
        if (endIndex >= startIndex) {

            // Gets the middle index of the range array given by start index and end index
            int middleIndex = getMiddleIndex(startIndex, endIndex);

            // If value in the middle index is the value we search for we can return the middle index
            if (array[middleIndex] == value) {
                return middleIndex;
            }

            // If the value is lesser than the value in the middle index we can search for the value in the first half of the array with lesser value
            if (array[middleIndex] > value) {
                return internalBinarySearch(array,value,0,middleIndex-1);
            }

            // If the value is bigger than the value in the middle index we can serach for the value in the second half of the array with bigger values
            else {
                return internalBinarySearch(array,value,middleIndex+1,endIndex);
            }
        }

        // Returns -1 if the value was not found
        return -1;
    }

    /**
     * Gets the middle index of the range indexes.
     * @param startIndex The start index.
     * @param endIndex The end index.
     * @return The middle index of this range.
     */
    private static int getMiddleIndex(int startIndex, int endIndex) {
        return startIndex + ((getArrayRange(startIndex,endIndex)) / 2);
    }

    /**
     * Gets the range of the array.
     * @param startIndex The start index of the array.
     * @param endIndex The end index of the array.
     * @return The range of the array.
     */
    private static int getArrayRange(int startIndex, int endIndex) {
        return endIndex - startIndex;
    }
}
