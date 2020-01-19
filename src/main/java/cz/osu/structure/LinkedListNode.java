package cz.osu.structure;

/**
 * Helpful package-private linked list node.
 */
class LinkedListNode {
    private int value;
    private LinkedListNode previousNode;
    private LinkedListNode nextNode;

    public LinkedListNode() {
        value = 0;
        previousNode = null;
        nextNode = null;
    }

    public LinkedListNode(int value) {
        this.value = value;
        previousNode = null;
        nextNode = null;
    }

    //<editor-fold desc="Getters and Setters">

    public LinkedListNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(LinkedListNode previousNode) {
        this.previousNode = previousNode;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    //</editor-fold>
}
