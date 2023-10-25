package ge.itstep.demo.service;

import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.User;
import ge.itstep.demo.repository.GameRepository;
import ge.itstep.demo.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ShipRepository shipRepository;

    private final int gridSize = 10;
    private boolean occupiedCells[][] = new boolean[gridSize][gridSize];

    public Game init(User user, int gridSize)
    {
        Game game = new Game();
        game.setGridSize(gridSize);
        game.setUser(user);
        return gameRepository.save(game);
    }

    private void generateShips()
    {
//        TODO: დავაგენერიროთ თითეული ტიპის გემი 2-2-ჯერ ისე რომ ისინი არ იკვეთებდონენ და განლაგება იყოს ვალიდური
    }

    public boolean shoot(int x, int y)
    {
//        TODO: X და Y კოორდინატზე ვეძებთ გემს და ვესვრით
        return false;
    }

    private void findOccupies(int x, int y, int gridsize)
    {
        if (x - 1 > -1) this.occupiedCells[x - 1][y] = true;
        if (x + 1 < gridsize) this.occupiedCells[x + 1][y] = true;
        if (y + 1 < gridsize) this.occupiedCells[x][y + 1] = true;
        if (y - 1 > -1) this.occupiedCells[x][y - 1] = true;
        if (x - 1 > -1 && y - 1 > 1) this.occupiedCells[x - 1][y - 1] = true;
        if (x - 1 > -1 && y + 1 < gridsize) this.occupiedCells[x - 1][y + 1] = true;
        if (x + 1 < gridsize && y + 1 < gridsize) this.occupiedCells[x + 1][y + 1] = true;
        if (x + 1 < gridsize && y - 1 > -1) this.occupiedCells[x + 1][y - 1] = true;
    }


}
