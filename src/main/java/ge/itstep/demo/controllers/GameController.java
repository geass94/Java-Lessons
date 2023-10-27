package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.User;
import ge.itstep.demo.repository.GameRepository;
import ge.itstep.demo.service.GameService;
import ge.itstep.demo.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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


}
