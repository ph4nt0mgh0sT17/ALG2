package cz.osu;

import java.util.Arrays;

public class LineageNode {

    private Person man;
    private Person woman;

    private LineageNode[] children;

    public LineageNode(Person man, Person woman, int childrenNumber) {
        this(childrenNumber);
        this.man = man;
        this.woman = woman;
    }

    public LineageNode(int childrenNumber) {
        this.children = new LineageNode[childrenNumber];
    }

    public Person getMan() {
        return man;
    }

    public Person getWoman() {
        return woman;
    }

    public LineageNode[] getChildren() {
        return children;
    }

    public void setMan(Person man) {
        this.man = man;
    }

    public void setWoman(Person woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "LineageNode{" +
                "man=" + man +
                ", woman=" + woman +
                '}';
    }
}
