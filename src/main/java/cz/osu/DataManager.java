package cz.osu;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.*;

/**
 * The manager of all data got from the excel file.
 */
public class DataManager {

    /**
     * The collection of all {@link DataItem}.
     */
    private ArrayList<DataItem> dataItems;

    /**
     * Creates the DataManager with all data.
     * @param lines The collection of all lines got from the excel file.
     */
    public DataManager(ArrayList<String> lines) {
        dataItems = new ArrayList<>();

        // Fills the collection Data Items from the file
        for (String line : lines) {
            DataItem currentItem = DataItem.createFromStringLine(line);

            if (currentItem != null) {
               dataItems.add(currentItem);
            }
        }
    }

    /**
     * Prints all data items to the console.
     */
    public void printAll() {
        for (DataItem item : dataItems) {
            System.out.println(item.toString());
        }
    }

    /**
     * Gets all data items that meet required region.
     * @param region The required region of the Data Item.
     * @return The collection of all data items with given region.
     */
    public ArrayList<DataItem> getRegion(String region) {
        ArrayList<DataItem> export = new ArrayList<>();

        // Searches through all data items and exports every data item that meets the region
        for (DataItem dataItem : dataItems) {
            if (dataItem.getRegion().equals(region)) {
                export.add(dataItem);
            }
        }

        return export;
    }

    /**
     * Gets the collection of all countries.
     * @return The collection of all countries.
     */
    public ArrayList<String> getCountries() {
        HashSet<String> countriesHashSet = new HashSet<>();

        for (DataItem item : dataItems) {
            countriesHashSet.add(item.getCountry());
        }

        return new ArrayList<>(countriesHashSet);
    }

    /**
     * Gets the statistics as the collection of all {@link DataResult}
     * @return The collection of all {@link DataResult}.
     */
    public ArrayList<DataResult> getStatistic() {
        Map<String, DataResult> statisticMap = new HashMap<>();

        // Goes through all Data Items
        for (DataItem item : dataItems) {

            // Gets the Data Result from the Map
            DataResult tempItem = statisticMap.get(item.getCountry().toLowerCase());

            // If the data result has once been in the map it will only increment the values
            if (tempItem != null) {
                tempItem.numberCases += item.getNewCases();
                tempItem.numberDeaths += item.getNewDeath();
            }

            // Otherwise it will create a new DataResult
            else {
                tempItem = new DataResult();
                tempItem.key = item.getCountry().toLowerCase();
                tempItem.numberCases = item.getNewCases();
                tempItem.numberDeaths = item.getNewDeath();
            }

            // Replaces the DataResult by new DataResult at given countryName
            statisticMap.put(item.getCountry().toLowerCase(), tempItem);
        }

        // Gets collection of all data results from the Map
        ArrayList<DataResult> export = new ArrayList<>(statisticMap.values());

        // Sorts the collection
        export.sort(Comparator.comparing(r -> r.key));

        return export;
    }

    /**
     * The bubble sort algorithm for the collection of {@link DataResult} items.
     * @param results The collection of {@link DataResult} items.
     */
    public static void bubbleSort(ArrayList<DataResult> results) {
        for (int i = 0; i < results.size() - 1; i++) {
            for (int j = 0; j < results.size() - i - 1; i++) {
                if(results.get(j).numberCases < results.get(j + 1).numberCases) {
                    DataResult temp = results.get(j);
                    results.set(j, results.get(j+1));
                    results.set(j+1, temp);
                }
            }
        }
    }
}
