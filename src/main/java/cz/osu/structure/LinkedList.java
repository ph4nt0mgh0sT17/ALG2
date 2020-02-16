package cz.osu.structure;

/**
 * The class of linked list node.
 */
public class LinkedList {

    private LinkedListNode headNode;
    private LinkedListNode tailNode;
    private int count;

    /**
     * Creates an empty linked list with no values.
     */
    public LinkedList() {
        headNode = tailNode = null;
    }

    /**
     * Creates a linked list with one value.
     * @param value - The first value in the linked list.
     */
    public LinkedList(int value) {
        internalInsertNodeToEmptyList(value);
    }

    /**
     * Adds the value to current linked list.
     * @param value The value
     */
    public void add(int value) {
        if (headNode == null) {
            internalInsertNodeToEmptyList(value);
        }

        else {
            internalInsertNodeToList(value);
        }
    }

    /**
     * Removes a value at given index.
     * @param index The index of the value.
     */
    public void removeAt(int index) {
        int currentIndex = 0;
        LinkedListNode currentNode = headNode;

        while (currentIndex != index) {
            currentNode = iterateNode(currentNode);
            currentIndex++;
        }

        internalRemoveNodeFromList(currentNode);
    }

    /**
     * Gets count of values in the list.
     * @return The count of values.
     */
    public int getCount() {
        return count;
    }

    /**
     * Gets average value of all values in the list.
     * @return The average value.
     */
    public double getAverageValue() {
        double sumNodes = 0;
        LinkedListNode currentNode = headNode;

        do {
            sumNodes += currentNode.getValue();
            currentNode = iterateNode(currentNode);
        } while (currentNode != headNode);

        return sumNodes / count;
    }

    /**
     * Renders whole linked list into String.
     * @return String representation of the linked list.
     */
    public String renderList() {
        String reportString = "";
        LinkedListNode currentNode = headNode;

        do {
            reportString += String.format("%s; ", currentNode.getValue());
            currentNode = iterateNode(currentNode);
        } while (currentNode != headNode);

        return reportString;
    }

    /**
     * Adds the linked list node with given value to the empty list.
     * @param value The value of linked list node
     */
    private void internalInsertNodeToEmptyList(int value) {
        createFirstNode(value);
        linkFirstNode();
        iterateCount();
    }

    /**
     * Create a instance of first node in the list.
     * @param value
     */
    private void createFirstNode(int value) {
        headNode = tailNode = new LinkedListNode(value);
    }

    /**
     * Links all connections to head node and tail node when first node in the list is created
     */
    private void linkFirstNode() {
        linkFirstHeadNode();
        linkFirstTailNode();
    }

    /**
     * Links all connections head node when first node in the list is created
     */
    private void linkFirstHeadNode() {
        headNode.setNextNode(tailNode);
        headNode.setPreviousNode(tailNode);
    }

    /**
     * Links all connections to tail node when first node in the list is created
     */
    private void linkFirstTailNode() {
        tailNode.setNextNode(headNode);
        tailNode.setPreviousNode(headNode);
    }


    /**
     * Inserts the node with given value to non-empty list.
     * @param value The given value of the linked list node.
     */
    private void internalInsertNodeToList(int value) {
        LinkedListNode newNode = new LinkedListNode(value);

        linkNewNode(newNode);
        tailNode = newNode;
        iterateCount();
    }

    /**
     * Link all connections to the new node.
     * @param newNode The new created node.
     */
    private void linkNewNode(LinkedListNode newNode) {
        tailNode.setNextNode(newNode);
        headNode.setPreviousNode(newNode);

        newNode.setPreviousNode(tailNode);
        newNode.setNextNode(headNode);
    }

    /**
     * Removes the node from linked list.
     * @param node The node to be removed!
     */
    private void internalRemoveNodeFromList(LinkedListNode node) {
        LinkedListNode nextNode = node.getNextNode();

        linkOverRemovedNode(node);

        if (isHeadNode(node)) {
            headNode = nextNode;
        }
    }

    /**
     * Links all connection over newly removed linked list node.
     * @param toBeRemoved The newly removed linked list node.
     */
    private void linkOverRemovedNode(LinkedListNode toBeRemoved) {
        LinkedListNode nextNode = toBeRemoved.getNextNode();
        LinkedListNode previousNode = toBeRemoved.getPreviousNode();

        nextNode.setPreviousNode(previousNode);
        previousNode.setNextNode(nextNode);
    }

    /**
     * Checks if the node is head node.
     * @param node The given node.
     * @return State if the node is head node.
     */
    private boolean isHeadNode(LinkedListNode node) {
        return node == headNode;
    }

    /**
     * Iterate current node to the next node.
     * @param node The current node.
     * @return Next node of the current node.
     */
    private LinkedListNode iterateNode(LinkedListNode node) {
        return node.getNextNode();
    }

    /**
     * Iterate count of values in the list.
     */
    private void iterateCount() {
        count++;
    }

    @Override
    public String toString() {
        return String.format("Current LinkedList: %s values; Average value: %s", count, getAverageValue());
    }
}
