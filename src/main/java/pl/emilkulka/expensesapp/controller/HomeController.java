package pl.emilkulka.expensesapp.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;


@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    private String home() {
        return "home";
    }
}
