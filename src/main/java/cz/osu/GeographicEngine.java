package cz.osu;

public class GeographicEngine {

    /**
     * Gets the distance (meters) between two given {@link Coordinate}.
     * @param first The first {@link Coordinate}.
     * @param second A second {@link Coordinate}.
     * @return The distance between two given {@link Coordinate} in meters.
     */
    public static double getDistance(Coordinate first, Coordinate second) {
        final double R = 6371e3;

        double latitudeRadianFirst = Math.toRadians(first.getLatitude());
        double latitudeRadianSecond = Math.toRadians(second.getLatitude());

        double latitudeDifference = Math.toRadians(second.getLatitude() - first.getLatitude());
        double longitudeDifference = Math.toRadians(second.getLongitude() - first.getLongitude());

        // I don't know what the F is going on at all
        double a = Math.sin(latitudeDifference / 2) * Math.sin(latitudeDifference / 2) +
                Math.cos(latitudeRadianFirst) * Math.cos(latitudeRadianSecond) *
                Math.sin(longitudeDifference / 2) * Math.sin(longitudeDifference / 2);

        double c = 2 * Math.atan2((Math.sqrt(a)),Math.sqrt(1 - a));

        return R * c;
    }
}
