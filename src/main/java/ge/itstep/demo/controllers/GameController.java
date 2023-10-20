package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.User;
import ge.itstep.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private UserService userService;

    public Game createGame(Authentication authentication, @RequestBody GameDTO dto)
    {
        User user = userService.findUserByEmail(authentication.getName());
        return new Game();

    }


}
