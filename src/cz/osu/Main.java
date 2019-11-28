package cz.osu;

import cz.osu.structure.LinkedList;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LinkedList newList = new LinkedList();

        Random random = new Random();

        for (int i = 1; i <= 25; i++) {
            newList.add(i);
        }

        newList.removeAt(0);
        newList.removeAt(5);

        System.out.println(newList);
        System.out.println(newList.renderList());
    }
}
