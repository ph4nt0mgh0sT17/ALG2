package cz.osu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        WorldCitiesDatabase database = new WorldCitiesDatabase();
        database.loadData();

        long startTime = System.nanoTime();
        CityItem[] searchedLocation = database.searchFiveCities(new Coordinate(49.8304,18.2500));
        long endTime = System.nanoTime();

        System.out.println("> SearchLocations: " + (endTime - startTime) / 1000 / 1000 + " ms");

        Arrays.stream(searchedLocation)
                .forEach(System.out::println);

    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                05. 04. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
