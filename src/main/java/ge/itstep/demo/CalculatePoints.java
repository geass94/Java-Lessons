package ge.itstep.demo;

import ge.itstep.demo.model.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculatePoints {

    static boolean occupiedCells[][] = new boolean[10][10];
    public static void main(String[] args) {

        final int gridSize = 10;

        List<Ship> ships = new ArrayList<>();

        for (int s = 0; s < 2; s++)
        {
            ships.add(generateShips(gridSize, ShipType.FOUR_SLOT));
            ships.add(generateShips(gridSize, ShipType.TWO_SLOT));
        }


        System.out.println(gridToString(occupiedCells));

        System.out.println(ships.toString());

    }

    public static Ship generateShips(int gridSize, ShipType type)
    {
        Random random = new Random();
        Ship ship = new Ship();
        int lowerLimit = 0, upperLimit = 9, x, y;
        boolean isHorizontal = random.nextInt() % 2 == 0;
        if (isHorizontal) {
            x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            while(x + type.getSize() > gridSize) {
                x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            }
            y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

            while (notInOccupiedArea(x, y, x + type.getSize(), y)) {
                markHolesAsOccupied(x, y, x + type.getSize(), y);
                ship.setX1(x);
                ship.setY1(y);
                ship.setX2(x + type.getSize());
                ship.setY2(y);
            }


        } else {
            x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            while (y + type.getSize() > gridSize) {
                y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            }
            while (notInOccupiedArea(x, y, x, y + type.getSize())) {
                markHolesAsOccupied(x, y, x, y + type.getSize());
                ship.setX1(x);
                ship.setY1(y);
                ship.setX2(x);
                ship.setY2(y + type.getSize());
            }

        }

        return ship;
    }

    public static void markHolesAsOccupied(int x1, int y1, int x2, int y2)
    {
        boolean isHorizontal = y1 == y2;
        if (isHorizontal) {
            for (int x = x1; x < x2; x++) {
                findOccupies(x, y1, 10);
            }
        } else {
            for (int y = y1; y < y2; y++) {
                findOccupies(x1, y, 10);
            }
        }

    }

    public static boolean notInOccupiedArea(int x1, int y1, int x2, int y2)
    {
        boolean isHorizontal = y1 == y2;
        if (isHorizontal) {
            for (int x = x1; x < x2; x++) {
                if (occupiedCells[x][y1]) return false;
            }
        } else {
            for (int y = y1; y < y2; y++) {
                if (occupiedCells[x1][y]) return false;
            }
        }
        return true;
    }

    public static void findOccupies(int x, int y, int gridsize)
    {
        if (x - 1 > -1) occupiedCells[x - 1][y] = true;
        if (x + 1 < gridsize) occupiedCells[x + 1][y] = true;
        if (y + 1 < gridsize) occupiedCells[x][y + 1] = true;
        if (y - 1 > -1) occupiedCells[x][y - 1] = true;
        if (x - 1 > -1 && y - 1 > -1) occupiedCells[x - 1][y - 1] = true;
        if (x - 1 > -1 && y + 1 < gridsize) occupiedCells[x - 1][y + 1] = true;
        if (x + 1 < gridsize && y + 1 < gridsize) occupiedCells[x + 1][y + 1] = true;
        if (x + 1 < gridsize && y - 1 > -1) occupiedCells[x + 1][y - 1] = true;
    }


    public static String gridToString(boolean[][] grid) {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                sb.append(grid[x][y] == true ? "X" : "_");
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}

class Ship {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Ship() {
    }

    public Ship(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean isHorizontal()
    {
        return y1 == y2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
