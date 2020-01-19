package cz.osu;

import cz.osu.structure.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            linkedList.add(random.nextInt(1000));
        }

        System.out.println(linkedList);
    }
}
