package ge.itstep.demo;

import java.util.ArrayList;
import java.util.List;

public class CalculatePoints {

    public static void main(String[] args) {

        final int gridSize = 10;

        List<Ship> ships = new ArrayList<>();


        Ship ship1 = new Ship(2,2, 5, 2);

//                          [X][Y]
        boolean occupiedCells[][] = new boolean[gridSize][gridSize];

        if (ship1.isHorizontal()) {
            for (int x = ship1.getX1(); x <= ship1.getX2(); x++) {

                occupiedCells[x][ship1.getY1()] = true;

                if (ship1.getX1() > 0) {
                    occupiedCells[x - 1][ship1.getY1()] = true;
                }
                if (ship1.getX2() < gridSize) {
                    occupiedCells[x + 1][ship1.getY1()] = true;
                }
                if (ship1.getY1() > 0) {
                    occupiedCells[x][ship1.getY1() - 1] = true;
                }
                if (ship1.getY2() < gridSize) {
                    occupiedCells[x][ship1.getY2() + 1] = true;
                }

                if (ship1.getX1() > 0 &&
                        ship1.getY1() > 0 &&
                        ship1.getX2() < gridSize &&
                        ship1.getY2() < gridSize
                ) {
                    occupiedCells[x - 1][ship1.getY1() - 1] = true;
                    occupiedCells[x - 1][ship1.getY1() + 1] = true;
                    occupiedCells[x + 1][ship1.getY2() - 1] = true;
                    occupiedCells[x + 1][ship1.getY2() - 1] = true;
                }

            }
        }

        System.out.println(gridToString(occupiedCells));

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

    public Ship(int x1, int y1, int endX, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = endX;
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
}
