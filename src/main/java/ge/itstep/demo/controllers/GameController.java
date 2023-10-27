package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.dto.ShipDTO;
import ge.itstep.demo.dto.ShootDTO;
import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.Ship;
import ge.itstep.demo.model.User;
import ge.itstep.demo.repository.GameRepository;
import ge.itstep.demo.repository.ShipRepository;
import ge.itstep.demo.service.GameService;
import ge.itstep.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ShipRepository shipRepository;

    @PostMapping
    @Transactional
    public GameDTO createGame(Authentication authentication)
    {
        User user = userService.findUserByEmail(authentication.getName());
        Game game = gameService.init(user, 10);
        return new GameDTO(game);
    }

    @GetMapping("/{id}")
    public GameDTO getGame(@PathVariable Long id)
    {
        return gameRepository.findById(id).map((GameDTO::new)).orElseThrow(() -> new IllegalArgumentException("Game not found by given ID"));
    }

    @PostMapping(value = "/{id}/shoot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShootDTO shoot(@PathVariable Long id, @RequestParam int x, @RequestParam int y) throws Exception
    {
        Game game = gameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Game not found"));
        if (game.getHits() <= 0) return new ShootDTO(-1, false, null);
        game.setHits( game.getHits() - 1 );
        gameRepository.save(game);

        for (Ship ship : game.getShips()) {
            if (x >= ship.getStartX() && x <= ship.getEndX() && y >= ship.getStartY() && y <= ship.getEndY()) {
                ship.hit();
                shipRepository.save(ship);
                int hits = game.hasWon() ? -2 : game.getHits();
                if (ship.isSunk()) return new ShootDTO(hits, true, new ShipDTO(
                        ship.getStartX(),
                        ship.getEndX(),
                        ship.getStartY(),
                        ship.getEndY()
                ));

                return new ShootDTO(game.getHits(), true, null);
            }
        }
        return new ShootDTO(game.getHits(), false, null);
    }


}
