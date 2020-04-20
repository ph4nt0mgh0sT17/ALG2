package cz.osu;

public class CityItem {

    private String name;
    private Coordinate coordinate;
    private String country;

    /**
     * Initializes the city.
     * @param name A name of the city.
     * @param latitude A latitude of the city.
     * @param longitude A longitude of the city.
     * @param country A country name of the city.
     */
    public CityItem(String name, double latitude, double longitude, String country) {
        this.name = name;
        this.coordinate = new Coordinate(latitude, longitude);
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "CityItem{" +
                "name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", country='" + country + '\'' +
                '}';
    }
}
