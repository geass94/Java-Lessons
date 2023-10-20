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

    public Game init(User user, int gridSize)
    {
        Game game = new Game();
        game.setGridSize(gridSize);
        game.setUser(user);
        return gameRepository.save(game);
    }


}
