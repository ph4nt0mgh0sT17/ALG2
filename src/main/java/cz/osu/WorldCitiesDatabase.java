package cz.osu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorldCitiesDatabase {

    private ArrayList<CityItem> cities;

    public WorldCitiesDatabase() {
        this.cities = new ArrayList<>();
    }

    /**
     * Loads all data from the CSV file.
     */
    public void loadData() {
        ArrayList<String> lines = FileManager.getFileContent("worldcities.csv");

        for (String line : lines) {

            // Checks using regex pattern for the values inside the line
            Pattern linePattern = Pattern.compile("\"([^\"]+)\",\"[^\"]+\",\"([0-9.-]+)\",\"([0-9.-]+)\",\"([^\"]+)\".*");
            Matcher lineMatcher = linePattern.matcher(line);

            // If there is match in the line
            if (lineMatcher.find()) {

                // Declares some main variables that will be used
                String cityName = lineMatcher.group(1);
                double latitude = Double.parseDouble(lineMatcher.group(2));
                double longitude = Double.parseDouble(lineMatcher.group(3));
                String countryName = lineMatcher.group(4);

                // Initializes the city item
                CityItem currentItem = new CityItem(cityName, latitude, longitude, countryName);

                // Adds created item to the list
                this.cities.add(currentItem);
            }

            else {
                // If there was no match add null value
                this.cities.add(null);
            }

        }
    }

    /**
     * Search for a nearest location to the {@link Coordinate}.
     * @param searchedCoordinate The coordinate where the location will be searched.
     * @return The nearest {@link CityItem} to the {@link Coordinate}.
     */
    public CityItem searchCity(Coordinate searchedCoordinate) {

        // At the beginning we should get first item in the list so we can compare it in the iteration loop
        CityItem searchedCity = this.cities.get(0);
        double currentNearestDistance = GeographicEngine.getDistance(searchedCoordinate, searchedCity.getCoordinate());

        for (int index = 1; index < this.cities.size(); index++) {

            // Gets the city item on current index
            CityItem currentCity = this.cities.get(index);

            // Checks if some city item in the list is null then skip the city item
            if (currentCity == null) {
                continue;
            }

            // Computes the distance between the city coordination to our given coordination
            double currentDistance = GeographicEngine.getDistance(searchedCoordinate, currentCity.getCoordinate());

            // Compares given coordinations if they are nearer than before
            if (currentDistance < currentNearestDistance) {
                searchedCity = currentCity;
                currentNearestDistance = currentDistance;
            }
        }

        return searchedCity;
    }

    /**
     * Searches for five nearest locations using {@link #searchCity(Coordinate) searchCity(Coordinate searchedCoordinate)}.
     * @param searchedCoordinate The coordinate where the cities will be searched.
     * @return The collection of 5 nearest cities.
     */
    public CityItem[] searchFiveCities(Coordinate searchedCoordinate) {

        // Backups all values because I will be deleting searched locations...
        ArrayList<CityItem> tempItems = new ArrayList<CityItem>(this.cities);

        CityItem[] searchedLocations = new CityItem[5];

        for (int index = 0; index < 5; index++) {

            // Gets the nearest city in current collection
            CityItem searchedLocation = this.searchCity(searchedCoordinate);
            searchedLocations[index] = searchedLocation;

            // Removes searched location so it will be not counted in the next iterations...
            this.cities.remove(searchedLocation);
        }

        // I will load the pointer to the all values inot the cities variable
        // No need for copying
        this.cities = tempItems;

        return searchedLocations;
    }
}
