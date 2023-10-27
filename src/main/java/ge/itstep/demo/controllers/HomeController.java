package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.GameDTO;
import ge.itstep.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private GameRepository gameRepository;

    public String home(Model model)
    {
        model.addAttribute("games", gameRepository.findAll().stream().map(GameDTO::new));

        return "index";
    }

}