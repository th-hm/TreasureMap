package main;

public class Adventurer {
    private String name;
    private int x;
    private int y;
    private Orientation orientation;
    private String movements;
    private int movementIndex;
    private int treasuresCollected;

    public Adventurer(String name, int x, int y, Orientation orientation) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.movementIndex = 0;
        this.treasuresCollected = 0;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }

    public void move(Map map) {
        if (movementIndex < movements.length()) {
            char move = movements.charAt(movementIndex);
            switch (move) {
                case 'A': advance(map); break;
                case 'G': turnLeft(); break;
                case 'D': turnRight(); break;
            }
            movementIndex++;
        }
    }

    private void advance(Map map) {
        int newX = x, newY = y;

        switch (orientation) {
            case NORTH: newY--; break;
            case SOUTH: newY++; break;
            case EAST: newX++; break;
            case WEST: newX--; break;
        }

        if (map.isWithinBounds(newX, newY) && !map.isMountain(newX, newY)) {
            x = newX;
            y = newY;
            if (map.getTreasureCount(x, y) > 0) {
                map.collectTreasure(x, y);
                treasuresCollected++;
            }
        }
    }

    private void turnLeft() {
        orientation = orientation.left();
    }

    private void turnRight() {
        orientation = orientation.right();
    }
}

