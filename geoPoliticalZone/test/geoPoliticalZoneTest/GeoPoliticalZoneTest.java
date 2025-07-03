package geoPoliticalZoneTest;

import geoPoliticalZone.GeoPoliticalZone;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoPoliticalZoneTest {
    @Test
    public void testGeoPoliticalZone() {
        assertEquals("NORTH_WEST", GeoPoliticalZone.getZone("kaduna"));
    }
}
