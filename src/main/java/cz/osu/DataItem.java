package cz.osu;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The item representing the record in the excel file.
 */
public class DataItem {

    /**
     * Date formatter for Date objects.
     */
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * The country of the data item.
     */
    private String country;

    /**
     * The number of new coronavirus cases.
     */
    private int newCases;

    /**
     * The number of new coronavirus deaths.
     */
    private int newDeath;

    /**
     * The region of the data item.
     */
    private String region;

    /**
     * The date of the data item.
     */
    private Date itemDate;

    /**
     * Default constructor for creting the data item.
     * @param country The country of the data item.
     * @param newCases The number of new cases.
     * @param newDeath The number of new deaths.
     * @param region The region of the data item.
     * @param itemDate The date object of the data item.
     */
    private DataItem(String country, int newCases, int newDeath, String region, Date itemDate) {
        this.country = country;
        this.newCases = newCases;
        this.newDeath = newDeath;
        this.region = region;
        this.itemDate = itemDate;
    }

    /**
     * Creates the data item from the line of the .csv file.
     * @param line The line got from the .csv file.
     * @return The constructed data item. If the data item could not be created, null is returned.
     */
    public static DataItem createFromStringLine(String line) {
        try {
            // Gets all values divided to the array
            String[] dataValues =  line.split(";");

            // Tries to create new data item
            return new DataItem(dataValues[1],Integer.parseInt(dataValues[2]),Integer.parseInt(dataValues[3]),dataValues[6],dateFormatter.parse(dataValues[0]));
        }

        // If there was some problem in creating the data item, the exception will be handled and null returned
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println(line);
            return null;
        }
    }


    /**
     * Gets the region of the Data Item.
     * @return The region string.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Gets the country of the Data Item.
     * @return The country string.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets the number of new cases.
     * @return The number of new cases.
     */
    public int getNewCases() {
        return newCases;
    }

    /**
     * Gets the number of new deaths.
     * @return The number of new deaths.
     */
    public int getNewDeath() {
        return newDeath;
    }

    /**
     * Represents the data item in the string.
     * @return Returns report representation of the Data Item.
     */
    @Override
    public String toString() {
        return "DataItem{" +
                "country='" + country + '\'' +
                ", newCases=" + newCases +
                ", newDeath=" + newDeath +
                ", region='" + region + '\'' +
                ", itemDate=" + dateFormatter.format(itemDate) +
                '}';
    }
}
