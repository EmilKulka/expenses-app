package pl.emilkulka.expensesapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.exception.expense.DescriptionLimitException;
import pl.emilkulka.expensesapp.exception.expense.InvalidTypeException;
import pl.emilkulka.expensesapp.exception.expense.NegativePriceException;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;

@Controller
@AllArgsConstructor
@RequestMapping("/expense-add")
public class ExpenseAddController {

    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;


    @GetMapping()
    private String expenseAdd(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense-add";
    }

    @PostMapping
    private String saveExpense(@Valid Expense expense, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "expense-add";
        }
        expenseService.saveExpense(expense);
        return "redirect:/expense-add";
    }
}
