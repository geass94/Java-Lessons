package ge.itstep.demo.service;

import ge.itstep.demo.model.Ship;
import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.ShipType;
import ge.itstep.demo.model.User;
import ge.itstep.demo.repository.GameRepository;
import ge.itstep.demo.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ShipRepository shipRepository;

    private static final int gridSize = 10;
    private static final boolean[][] occupiedCells = new boolean[gridSize][gridSize];

    public Game init(User user, Integer gridSize)
    {
        Game game = new Game();
        game.setGridSize(gridSize);
        game.setUser(user);
        List<Ship> shipList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Ship s1 = generateShip(ShipType.FOUR_SLOT);
            s1.setGame(game);
            shipList.add(shipRepository.save(s1));
            Ship s2 = generateShip(ShipType.TWO_SLOT);
            s2.setGame(game);
            shipList.add(shipRepository.save(s2));
        }
        game.setShips(shipList);
        return gameRepository.save(game);
    }

    public boolean shoot(int x, int y)
    {
//        TODO: X და Y კოორდინატზე ვეძებთ გემს და ვესვრით
        return false;
    }

    public static Ship generateShip(ShipType type) {
        Random random = new Random();
        Ship ship = new Ship();
        ship.setType(type);
        int lowerLimit = 0, upperLimit = 9, x, y;
        boolean isHorizontal = random.nextInt() % 2 == 0;
        if (isHorizontal) {
            while (ship.getStartX() + ship.getEndX() + ship.getStartY() + ship.getEndY() == 0) {
                x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                while (x + type.getSize() > gridSize) {
                    x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                }
                y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

                while (notInOccupiedArea(x, y, x + type.getSize(), y)) {
                    markHolesAsOccupied(x, y, x + type.getSize(), y);
                    ship.setStartX(x);
                    ship.setStartY(y);
                    ship.setEndX(x + type.getSize() - 1);
                    ship.setEndY(y);
                }
            }
        } else {
            while (ship.getStartX() + ship.getEndX() + ship.getStartY() + ship.getEndY() == 0) {
                x = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                while (y + type.getSize() > gridSize) {
                    y = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                }
                while (notInOccupiedArea(x, y, x, y + type.getSize())) {
                    markHolesAsOccupied(x, y, x, y + type.getSize());
                    ship.setStartX(x);
                    ship.setStartY(y);
                    ship.setEndX(x);
                    ship.setEndY(y + type.getSize() - 1);
                }
            }
        }

        return ship;
    }

    static void findOccupies(int x, int y)
    {
        if (x - 1 > -1) occupiedCells[x - 1][y] = true;
        if (x + 1 < gridSize) occupiedCells[x + 1][y] = true;
        if (y + 1 < gridSize) occupiedCells[x][y + 1] = true;
        if (y - 1 > -1) occupiedCells[x][y - 1] = true;
        if (x - 1 > -1 && y - 1 > -1) occupiedCells[x - 1][y - 1] = true;
        if (x - 1 > -1 && y + 1 < gridSize) occupiedCells[x - 1][y + 1] = true;
        if (x + 1 < gridSize && y + 1 < gridSize) occupiedCells[x + 1][y + 1] = true;
        if (x + 1 < gridSize && y - 1 > -1) occupiedCells[x + 1][y - 1] = true;
    }

    private static void markHolesAsOccupied(int x1, int y1, int x2, int y2) {
        boolean isHorizontal = y1 == y2;
        if (isHorizontal) {
            for (int x = x1; x < x2; x++) {
                findOccupies(x, y1);
            }
        } else {
            for (int y = y1; y < y2; y++) {
                findOccupies(x1, y);
            }
        }

    }

    private static boolean notInOccupiedArea(int x1, int y1, int x2, int y2) {
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


}
