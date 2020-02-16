package cz.osu.structure;

/**
 * Complete array list class that is interacted through the array.
 */
public class ArrayList {

    /**
     * Whole array list of all values.
     */
    private int[] arrayList;

    /**
     * Creates an empty array list.
     */
    public ArrayList() {
        arrayList = new int[0];
    }

    /**
     * Creates an array list where the array is copied.
     *
     * @param array The array to be copied into ArrayList.
     */
    public ArrayList(int[] array) throws Exception {
        arrayList = new int[0];
        addRange(array);
    }

    /**
     * Adds a value to the array list.
     *
     * @param value
     */
    public void add(int value) {
        expandArray();
        arrayList[arrayList.length - 1] = value;
    }

    /**
     * Adds a whole range of values to array list.
     *
     * @param arrayValues
     * @throws Exception
     */
    public void addRange(int[] arrayValues) throws Exception {

        // Checks if array to be inserted is empty -> which is forbidden
        if (isArrayEmpty(arrayValues)) {
            throw new Exception("The array cannot be empty.");
        }

        // Adds all values from the added array to our array list
        for (int i = 0; i < arrayValues.length; i++) {
            add(arrayValues[i]);
        }
    }

    /**
     * Removes the value at given index.
     *
     * @param index The given index.
     * @throws Exception Throws exception if the index is not valid.
     */
    public void removeAt(int index) throws Exception {

        // Checks if the index is in the boundary of our list
        if (!isIndexValid(index)) {
            throw new Exception("The index is out of bounds!");
        }

        // Removes the value on given index
        removeValueAt(index);

        // Moves the list so there are no null spaces in the array
        moveListAfterRemove(index);
    }

    /**
     * Search the value in the list. If found return boolean value.
     *
     * @param value The searched value.
     * @return Boolean value.
     */
    public boolean search(int value) {

        // Search through whole array list and tries to find the value
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == value) {
                return true;
            }
        }

        // If there was no value found
        return false;
    }

    /**
     * Search quantity of values in the list.
     *
     * @param value The value contained in the list.
     * @return The quantity of values.
     */
    public int searchQuantity(int value) {
        return internalSearchQuantity(value);
    }

    /**
     * Searches the value at given index.
     *
     * @param index The given index.
     * @return The value on given index.
     * @throws Exception Throws exception if the index is not valid.
     */
    public int searchAt(int index) throws Exception {

        // Checks if the index is in the boundary of our list
        if (!isIndexValid(index)) {
            throw new Exception("The index is out of bounds!");
        }

        // Returns the value on given index
        return arrayList[index];
    }

    /**
     * Count of values in the list.
     */
    public int count() {
        return arrayList.length;
    }

    private int internalSearchQuantity(int value) {
        int valueQuantity = 0;

        // Search through whole array list
        for (int i = 0; i < arrayList.length; i++) {

            // If there is value we try to find we can increment our valueQuantity
            if (arrayList[i] == value) {
                valueQuantity++;
            }
        }

        return valueQuantity;
    }

    /**
     * Move whole list after remove to be in perfect order.
     *
     * @param index Index of removed value.
     */
    private void moveListAfterRemove(int index) {

        // We move all following values of removed value to the left so we can remove the created new space (0)
        for (int i = index; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
    }

    /**
     * Removes the value of index -> we set it to 0.
     * @param index The given index
     */
    private void removeValueAt(int index) {
        arrayList[index] = 0;
    }

    /**
     * Checks if the index is within the boundaries.
     * @param index The index.
     * @return The state of the index.
     */
    private boolean isIndexValid(int index) {
        return (index < arrayList.length || index > 0);
    }

    /**
     * Checks if the array is empty.
     *
     * @param array The checked array.
     * @return The state of emptiness.
     */
    private boolean isArrayEmpty(int[] array) {
        return (array.length == 0);
    }

    /**
     * Expands the array by 1 position.
     */
    private void expandArray() {

        // Creates a new array with incremented length
        //TODO: Should implement incrementing the array by half of the current length to make sure copying array won't be repeating after every insert
        int[] tempArray = new int[arrayList.length + 1];

        // Copies all values from old array to the new array
        copyArrayTo(arrayList, tempArray);

        // We set our new array as our main
        // The old array gets removed by Garbage Collector on the end of the method
        arrayList = tempArray;
    }

    /**
     * Copy the array to some array.
     *
     * @param whatArray The copied array.
     * @param toArray   The destination array.
     */
    private void copyArrayTo(int[] whatArray, int[] toArray) {

        // Copies all values from first array to the second array
        for (int i = 0; i < whatArray.length; i++) {
            toArray[i] = whatArray[i];
        }
    }
}
