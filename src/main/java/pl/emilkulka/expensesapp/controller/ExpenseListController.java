package pl.emilkulka.expensesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;

@Controller
@RequestMapping("/expense-list")
public class ExpenseListController {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseListController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping()
    private String expenseList(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "expense-list";
    }

    @PostMapping
    private String deleteById(Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expense-list";
    }
}
