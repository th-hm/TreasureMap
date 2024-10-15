package main;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the map with width 5 and height 4
        Map map = new Map(5, 4);

        // Add mountains to the map
        map.addMountain(1, 0);
        map.addMountain(2, 1);

        // Add treasures to the map
        map.addTreasure(0, 3, 2);
        map.addTreasure(1, 3, 3);

        // Initialize an adventurer and set their movements
        Adventurer lara = new Adventurer("Lara", 1, 1, Orientation.SOUTH);
        lara.setMovements("AADADAGGA");

        // Add the adventurer to the map
        map.addAdventurer(lara);

        // Display the initial state of the map
        System.out.println("Initial state of the map:");
        map.display();

        // Execute the adventurer's movements
        for (int i = 0; i < 10; i++) {  // We limit to 10 steps for this example
            map.executeAdventurerMoves();
        }

        // Display the final state of the map
        System.out.println("\nFinal state of the map:");
        map.display();
    }
}
