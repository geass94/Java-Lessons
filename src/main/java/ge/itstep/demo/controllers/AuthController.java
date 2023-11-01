package ge.itstep.demo.controllers;

import ge.itstep.demo.dto.UserDTO;
import ge.itstep.demo.events.CustomEventPublisher;
import ge.itstep.demo.service.UserService;
import ge.itstep.demo.service.UserServiceImpl;
import jakarta.validation.Valid;

import java.util.Optional;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private final CustomEventPublisher publisher;

    public AuthController(UserService userService, CustomEventPublisher publisher) {
        this.publisher = publisher;
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

    @PostMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> triggerEvent()
    {
        this.publisher.publishCustomEvent();
        return ResponseEntity.ok("I did this"); 
    }

}
