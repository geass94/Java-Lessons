package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.UserDTO;
import ge.itstep.demo.service.UserService;
import ge.itstep.demo.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

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
            Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("user", dto);
            return "/registration";
        }

        userService.saveUser(dto);

        return "redirect:/registration?success";
    }


    @RequestMapping("/login")
    public String loginForm()
    {
        return "login";
    }

}
