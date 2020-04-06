package cz.osu;

public class Coordinate {

    private double latitude;
    private double longitude;

    /**
     * Initializes the coordinate with given latitude and longitude.
     * @param latitude A latitude.
     * @param longitude A longitude.
     */
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
