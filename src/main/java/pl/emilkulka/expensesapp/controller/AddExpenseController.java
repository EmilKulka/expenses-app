package pl.emilkulka.expensesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;

@Controller
@RequestMapping("/add-expense")
public class AddExpenseController {
    private final ExpenseRepository expenseRepository;
    @Autowired
    public AddExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping()
    private String addExpense() {
        return "add-expense";
    }
    @PostMapping
    private String saveExpense(Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/";
    }
}
