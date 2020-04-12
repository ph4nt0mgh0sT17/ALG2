package cz.osu;

import java.util.Random;

public class Lineage {

    private static Random random;

    // Static constructor...
    static {
        random = new Random();
    }

    private static Random rnd = new Random();

    public static void simulateLineage(LineageNode parents){
        LineageNode[] children = parents.getChildren();
        for (int i = 0; i < children.length; i++) {
            Person child = generatePerson(parents.getMan().getSurname());
            children[i] = new LineageNode(generateChildrenCount());
            if(child.getSex() == Sex.MALE){
                children[i].setMan(child);
                Person woman = generatePerson(Sex.FEMALE);
                woman.setSurname(child.getSurname());
                children[i].setWoman(woman);
            }
            else {
                Person man = generatePerson(Sex.MALE);
                child.setSurname(man.getSurname());
                children[i].setWoman(child);
                children[i].setMan(man);
            }
            simulateLineage(children[i]);
        }
    }

    private static int generateChildrenCount() {
        double p = rnd.nextDouble();

        /*
        if(p <= 0.15){
            return 0;
        }
        else if(p <= 0.28){
            return 1;
        }
        else if(p <= 0.65){
            return 2;
        }
        else if(p <= 0.87){
            return 3;
        }
        else {
            return 4;
        }
         */

        if(p <= 0.4){
            return 0;
        }
        else if(p <= 0.7){
            return 1;
        }
        else if(p <= 0.9){
            return 2;
        }
        else{
            return 3;
        }
    }

    private static Person generatePerson(String parentSurname) {
        Sex sex = rnd.nextBoolean() ? Sex.MALE : Sex.FEMALE;
        String surname = parentSurname;
        String name = "";

        if(sex == Sex.MALE){
            name = Generator.generateManName();
        }
        else {
            name = Generator.generateWomenName();
        }
        return new Person(name, surname, sex);
    }

    private static Person generatePerson(Sex sex){
        String surname = "";
        String name = "";

        if(sex == Sex.MALE){
            name = Generator.generateManName();
            surname = Generator.generateManSurname();
        }
        else {
            name = Generator.generateWomenName();
            surname = Generator.generateWomenSurname();
        }
        return new Person(name, surname, sex);
    }

    public static void printLineage(LineageNode parents, int tabNumber){
        LineageNode[] children = parents.getChildren();
        if(children.length == 0){
            return;
        }
        if(tabNumber == 0){
            System.out.println(tabNumber + ". generace");
            System.out.println(parents);
        }


        for (int i = 0; i < children.length; i++) {
            System.out.println(tabBuilder(tabNumber + 1) + (tabNumber + 1) + ". generace");
            System.out.println(tabBuilder(tabNumber + 1) + children[i]);
            printLineage(children[i], tabNumber + 1);
        }
    }

    private static String tabBuilder(int count){
        String ret = "";

        for (int i = 0; i < count; i++) {
            ret += "\t";
        }

        return ret;
    }
}
