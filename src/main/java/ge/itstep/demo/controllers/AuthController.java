package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @Valid
            @ModelAttribute("user") UserDTO dto,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors()) {
            model.addAttribute("user", dto);
            return "/registration";
        }

        return "registration";
    }





}
