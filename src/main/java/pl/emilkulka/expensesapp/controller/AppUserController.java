package pl.emilkulka.expensesapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.emilkulka.expensesapp.dto.AppUserDto;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.service.AppUserDetailsService;
import pl.emilkulka.expensesapp.service.UserService;

@Controller
public class AppUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") AppUserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") AppUserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message", "Zarejestrowano pomyślnie!");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
