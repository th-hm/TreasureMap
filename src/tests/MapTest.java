package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Map;

class MapTest {

    private Map map;

    @BeforeEach
    public void setup() {
        map = new Map(5, 4);
    }

    @Test
    public void testAddMountain() {
        map.addMountain(1, 2);
        assertTrue(map.isMountain(1, 2));
    }

    @Test
    public void testAddTreasure() {
        map.addTreasure(0, 3, 2);
        assertEquals(2, map.getTreasureCount(0, 3));
    }

    @Test
    public void testCollectTreasure() {
        map.addTreasure(0, 3, 2);
        map.collectTreasure(0, 3);
        assertEquals(1, map.getTreasureCount(0, 3));
    }

    @Test
    public void testIsWithinBounds() {
        assertTrue(map.isWithinBounds(0, 0));
        assertTrue(map.isWithinBounds(4, 3));
        assertFalse(map.isWithinBounds(5, 4));
        assertFalse(map.isWithinBounds(-1, 0));
    }
}
