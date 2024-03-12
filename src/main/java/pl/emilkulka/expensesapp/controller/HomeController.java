package pl.emilkulka.expensesapp.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;

import java.util.List;


@Controller
public class HomeController {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public HomeController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Expense> home(Model model, HttpSession httpSession) {
        model.addAttribute("expenses",expenseRepository.findAll());
        return expenseRepository.findAll();
    }
}
