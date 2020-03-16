package cz.osu;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        ArrayList<String> lines = FileManager.fileFromResources("COVID-19_15.csv");

        DataManager dataManager = new DataManager(lines);

        ArrayList<String> countries = dataManager.getCountries();

       ArrayList<DataResult> statistics = dataManager.getStatistic();
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                02. 03. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
