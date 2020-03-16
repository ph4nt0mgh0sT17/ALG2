package cz.osu;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataItem {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    private String country;
    private int newCases;
    private int newDeath;
    private String region;
    private Date itemDate;

    private DataItem(String country, int newCases, int newDeath, String region, Date itemDate) {
        this.country = country;
        this.newCases = newCases;
        this.newDeath = newDeath;
        this.region = region;
        this.itemDate = itemDate;
    }

    public static DataItem createFromStringLine(String line) {
        try {
            String[] dataValues =  line.split(";");
            return new DataItem(dataValues[1],Integer.parseInt(dataValues[2]),Integer.parseInt(dataValues[3]),dataValues[6],dateFormatter.parse(dataValues[0]));
        }

        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println(line);
            return null;
        }
    }


    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public int getNewCases() {
        return newCases;
    }

    public int getNewDeath() {
        return newDeath;
    }

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
