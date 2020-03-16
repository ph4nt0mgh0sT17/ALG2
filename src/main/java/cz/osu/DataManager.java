package cz.osu;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataManager {

    private ArrayList<DataItem> dataItems;

    public DataManager(ArrayList<String> lines) {
        dataItems = new ArrayList<>();

        for (String line : lines) {
            DataItem currentItem = DataItem.createFromStringLine(line);

            if (currentItem != null) {
               dataItems.add(currentItem);
            }
        }
    }

    public void printAll() {
        for (DataItem item : dataItems) {
            System.out.println(item.toString());
        }
    }

    public ArrayList<DataItem> getRegion(String region) {
        ArrayList<DataItem> export = new ArrayList<>();

        for (int i = 0; i < dataItems.size(); i++) {
            if (dataItems.get(i).getRegion().equals(region)) {
                export.add(dataItems.get(i));
            }
        }

        return export;
    }

    public ArrayList<String> getCountries() {
        HashSet<String> countriesHashSet = new HashSet<>();

        for (DataItem item : dataItems) {
            countriesHashSet.add(item.getCountry());
        }

        return new ArrayList<>(countriesHashSet);
    }

    public ArrayList<DataResult> getStatistic() {
        Map<String, DataResult> statisticMap = new HashMap<>();

        for (DataItem item : dataItems) {
            DataResult tempItem = statisticMap.get(item.getCountry().toLowerCase());

            if (tempItem != null) {
                tempItem.numberCases += item.getNewCases();
                tempItem.numberDeaths += item.getNewDeath();
            }

            else {
                tempItem = new DataResult();
                tempItem.key = item.getCountry().toLowerCase();
                tempItem.numberCases = item.getNewCases();
                tempItem.numberDeaths = item.getNewDeath();
            }

            statisticMap.put(item.getCountry().toLowerCase(), tempItem);
        }

        ArrayList<DataResult> export= new ArrayList<>(statisticMap.values());

        export.sort((r1, r2) -> (r1.key.compareTo(r2.key)));

        return export;
    }

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
