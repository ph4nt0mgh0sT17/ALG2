import cz.osu.CityItem;
import cz.osu.WorldCitiesDatabase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldCitiesDatabaseTest {

    private static WorldCitiesDatabase database;


    @BeforeAll
    private static void setUp() {
        database = new WorldCitiesDatabase();
    }

    @Test
    void testDatabase() {
        List<CityItem> cities = database.loadData();

        assertNotNull(cities);
    }
}
