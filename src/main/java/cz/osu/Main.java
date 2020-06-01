package cz.osu;


public class Main {

    /*
     *  This program will serve for testing my skill-set for 7ALG2.
     *
     *  The goal is to create a class of User that is within some database. We can sort the database, search in the database.
     */

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        UserDatabase userDatabase = new UserDatabase();

        userDatabase.loadUserDatabase();
        userDatabase.fillDatabase();


        System.out.println();

        userDatabase.sortByFirstName();

        System.out.println();

        userDatabase.sortBySecondName();

        System.out.println();

        userDatabase.sortByAge();
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                06. 01. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
