package cz.osu;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorldCitiesDatabase {

    /**
     * The {@link ArrayList} of cities.
     */
    private ArrayList<CityItem> cities;

    /**
     * The main constructor of the {@link WorldCitiesDatabase}.
     * It is constructed with an empty {@link ArrayList} of cities.
     */
    public WorldCitiesDatabase() {
        cities = new ArrayList<>();
    }

    /**
     * Loads all data from the CSV file.
     */
    public ArrayList<CityItem> loadData() {
        ArrayList<String> csvLines = FileManager.getFileContent("worldcities.csv");

        Pattern linePattern = getCsvLinePattern();

        evaluateAllLines(csvLines, linePattern);

        return cities;
    }

    /**
     * Gets the CSV line RegEx pattern.
     */
    private Pattern getCsvLinePattern() {
        return Pattern.compile(
                "\"([^\"]+)\" # Gets the name of the city from the line .csv\n" +
                        ",\"[^\"]+\", # Ignores the second name of the city\n" +
                        "\"([0-9.-]+)\", # Gets the latitude\n" +
                        "\"([0-9.-]+)\", # Gets the longitude\n" +
                        "\"([^\"]+)\" # Gets the country name\n" +
                        ".* # Everything else is ignored\n",
                Pattern.COMMENTS | Pattern.DOTALL);
    }

    /**
     * Evaluate all lines from the {@link ArrayList} csvLines with the {@link Pattern} linePattern.
     * @param csvLines The {@link ArrayList} of the CSV.
     * @param linePattern The RegEx {@link Pattern} of every line.
     */
    private void evaluateAllLines(ArrayList<String> csvLines, Pattern linePattern) {

        csvLines.forEach(csvLine -> {
            Matcher lineMatcher = linePattern.matcher(csvLine);
            evaluateMatch(lineMatcher);
        });
    }

    /**
     * Evaluate a match of the {@link Matcher}.
     * @param lineMatcher The {@link Matcher} that contains all matches from the RegEx.
     */
    private void evaluateMatch(Matcher lineMatcher) {
        if (lineMatcher.find()) {
            CityItem currentItem = buildCityItem(lineMatcher);
            cities.add(currentItem);
        }

        else {
            cities.add(null);
        }
    }

    /**
     * Builds the {@link CityItem} using the RegEx {@link Matcher}.
     * @param lineMatcher The regex {@link Matcher} where are the {@link CityItem} values.
     * @return The built {@link CityItem}.
     */
    private CityItem buildCityItem(Matcher lineMatcher) {
        String cityName = lineMatcher.group(1);
        double latitude = Double.parseDouble(lineMatcher.group(2));
        double longitude = Double.parseDouble(lineMatcher.group(3));
        String countryName = lineMatcher.group(4);

        return new CityItem(cityName, latitude, longitude, countryName);
    }

    /**
     * Search for a nearest location to the {@link Coordinate}.
     * @param searchedCoordinate The coordinate where the location will be searched.
     * @return The nearest {@link CityItem} to the {@link Coordinate}.
     */
    public CityItem searchCity(Coordinate searchedCoordinate) {

        CityItem searchedCity = this.cities.get(0);
        double nearestDistance = GeographicEngine.getDistance(searchedCoordinate, searchedCity.getCoordinate());

        for (int index = 1; index < this.cities.size(); index++) {

            CityItem currentCity = this.cities.get(index);

            if (currentCity != null) {

                double currentCityDistance = GeographicEngine.getDistance(searchedCoordinate, currentCity.getCoordinate());

                if (currentCityDistance < nearestDistance) {
                    searchedCity = currentCity;
                    nearestDistance = currentCityDistance;
                }
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

        ArrayList<CityItem> tempItems = new ArrayList<>(cities);
        CityItem[] searchedLocations = new CityItem[5];

        internalSearchFiveCities(searchedCoordinate, searchedLocations);

        cities = tempItems;

        return searchedLocations;
    }

    /**
     * Searches for all nearest five cities.
     * @param currentCoordinate The #{@link }
     * @param searchedLocations
     */
    private void internalSearchFiveCities(Coordinate currentCoordinate, CityItem[] searchedLocations) {
        for (int index = 0; index < 5; index++) {
            CityItem searchedLocation = searchCity(currentCoordinate);
            searchedLocations[index] = searchedLocation;
            cities.remove(searchedLocation);
        }
    }
}
