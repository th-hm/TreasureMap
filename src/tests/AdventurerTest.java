package tests;

import static org.junit.jupiter.api.Assertions.*;

import main.Adventurer;
import main.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Map;


class AdventurerTest {

    private Map map;
    private Adventurer adventurer;

    @BeforeEach
    public void setup() {
        map = new Map(5, 4);
        adventurer = new Adventurer("Lara", 1, 1, Orientation.NORTH);
        map.addAdventurer(adventurer);
    }

    @Test
    public void testMoveAdvance() {
        adventurer.setMovements("A");
        adventurer.move(map);
        assertEquals(1, adventurer.getX());
        assertEquals(0, adventurer.getY()); // Moves north
    }

    @Test
    public void testTurnLeft() {
        adventurer.setMovements("G");
        adventurer.move(map);
        assertEquals(Orientation.WEST, adventurer.getOrientation());
    }

    @Test
    public void testTurnRight() {
        adventurer.setMovements("D");
        adventurer.move(map);
        assertEquals(Orientation.EAST, adventurer.getOrientation());
    }

    @Test
    public void testCollectTreasure() {
        map.addTreasure(1, 0, 1); // Place treasure in the next tile
        adventurer.setMovements("A");
        adventurer.move(map); // Moves and collects the treasure
        assertEquals(0, map.getTreasureCount(1, 0)); // Treasure should be collected
    }

    @Test
    public void testAvoidMountain() {
        map.addMountain(1, 0); // Block the way with a mountain
        adventurer.setMovements("A");
        adventurer.move(map);
        assertEquals(1, adventurer.getX());
        assertEquals(1, adventurer.getY()); // Should stay in place
    }

    @Test
    public void testMoveOutOfBounds() {
        adventurer.setMovements("A");
        adventurer.move(map); // Moves north to 1,0
        adventurer.setMovements("A");
        adventurer.move(map); // Attempt to move out of bounds
        assertEquals(1, adventurer.getX());
        assertEquals(0, adventurer.getY()); // Should stay within bounds
    }
    
}
