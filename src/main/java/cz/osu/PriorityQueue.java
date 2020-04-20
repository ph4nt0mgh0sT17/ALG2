package cz.osu;

public class PriorityQueue {

    private HuffmanNode head;
    private int nodesCount;

    public int getNodesCount() {
        return nodesCount;
    }

    public PriorityQueue(){

        head = null;
        nodesCount = 0;
    }

    public void addNode(HuffmanNode nodeToAdd){

        nodesCount++;

        if(head == null){

            head = nodeToAdd;
            return;
        }

        if(head.getFrequency() > nodeToAdd.getFrequency()){

            nodeToAdd.setNext(head);
            head = nodeToAdd;
            return;
        }

        HuffmanNode start = head;

        while (start.getNext() != null && start.getNext().getFrequency() < nodeToAdd.getFrequency()) {
            start = start.getNext();
        }

        nodeToAdd.setNext(start.getNext());
        start.setNext(nodeToAdd);

    }

    public HuffmanNode pop(){

        if(head == null) return null;

        nodesCount--;

        HuffmanNode temp = head;
        head = head.getNext();

        return temp;
    }

    public void printAll(){

        HuffmanNode start = head;

        while (start != null) {

            System.out.println(start);
            start = start.getNext();
        }
    }
}
