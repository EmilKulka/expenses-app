package pl.emilkulka.expensesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;

@Controller
@RequestMapping("/delete")
public class TestController {

    private final ExpenseRepository expenseRepository;
    @Autowired
    public TestController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    private String deleteExpense() {
        return "test";
    }

    @PostMapping
    private String deleteById(Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/";
    }
}
