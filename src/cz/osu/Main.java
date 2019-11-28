package cz.osu;

import cz.osu.structure.ArrayList;
import cz.osu.structure.LinkedList;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        /*LinkedList newList = new LinkedList();

        Random random = new Random();

        for (int i = 1; i <= 25; i++) {
            newList.add(i);
        }

        newList.removeAt(0);
        newList.removeAt(5);

        System.out.println(newList);
        System.out.println(newList.renderList());*/

        ArrayList newArrayList = new ArrayList();

        for (int i = 0; i < 50; i++) {
            newArrayList.add(i*2);
        }

        for (int i = 0; i < newArrayList.count(); i++) {
            System.out.print(newArrayList.searchAt(i) +"; ");
        }

        System.out.println();

        int[] copyArray = new int[] {
                15, 56, 44, 156, 45, 77
        };

        ArrayList anotherList = new ArrayList(copyArray);

        for (int i = 0; i < anotherList.count(); i++) {
            System.out.print(anotherList.searchAt(i) +"; ");
        }
    }
}
