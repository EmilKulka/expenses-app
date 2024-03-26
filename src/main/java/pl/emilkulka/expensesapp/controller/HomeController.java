package pl.emilkulka.expensesapp.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public HomeController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping()
    private String home(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "home";
    }

    @PostMapping
    private String deleteById(Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/";
    }
}
