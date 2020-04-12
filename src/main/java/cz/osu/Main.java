package cz.osu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        Person man = new Person("Josef", "Novák", Sex.MALE);
        Person woman = new Person("Marie", "Stará", Sex.FEMALE);
        LineageNode first = new LineageNode(man, woman, 2);
        Lineage.simulateLineage(first);
        Lineage.printLineage(first, 0);
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                06. 04. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
