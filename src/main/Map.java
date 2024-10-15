package main;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private int width;
    private int height;
    private int[][] treasures; // Treasure grid
    private boolean[][] mountains; // Mountain grid
    private List<Adventurer> adventurers; // List of adventurers

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        treasures = new int[width][height];
        mountains = new boolean[width][height];
        adventurers = new ArrayList<>();
    }

    public void addMountain(int x, int y) {
        mountains[x][y] = true;
    }

    public void addTreasure(int x, int y, int count) {
        treasures[x][y] = count;
    }

    public boolean isMountain(int x, int y) {
        return mountains[x][y];
    }

    public int getTreasureCount(int x, int y) {
        return treasures[x][y];
    }

    public void collectTreasure(int x, int y) {
        if (treasures[x][y] > 0) {
            treasures[x][y]--;
        }
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public void executeAdventurerMoves() {
        for (Adventurer adventurer : adventurers) {
            adventurer.move(this);
        }
    }

    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (isMountain(x, y)) {
                    System.out.print("M ");
                } else if (treasures[x][y] > 0) {
                    System.out.print("T(" + treasures[x][y] + ") ");
                } else {
                    boolean adventurerFound = false;
                    for (Adventurer adventurer : adventurers) {
                        if (adventurer.getX() == x && adventurer.getY() == y) {
                            System.out.print(adventurer.getName().charAt(0) + " ");
                            adventurerFound = true;
                            break;
                        }
                    }
                    if (!adventurerFound) {
                        System.out.print("_ ");
                    }
                }
            }
            System.out.println();
        }
    }
}

