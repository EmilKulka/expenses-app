package pl.emilkulka.expensesapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;

@Controller
@AllArgsConstructor
@RequestMapping("/expense-list")
public class ExpenseListController {

    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;


    @GetMapping()
    private String expenseList(Model model) {
        model.addAttribute("expenses", expenseRepository.findAll());
        return "expense-list";
    }

    @PostMapping
    private String deleteById(Long id) {
        expenseService.deleteById(id);
        return "redirect:/expense-list";
    }

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "expense-edit";
    }

    @PostMapping("/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") @Valid Expense expense, BindingResult bindingResult, Model model) {
        Expense expenseToBeEdited = expenseService.getExpenseById(id);

        expenseToBeEdited.setId(id);
        expenseToBeEdited.setType(expense.getType());
        expenseToBeEdited.setDescription(expense.getDescription());
        expenseToBeEdited.setPrice(expense.getPrice());
        expenseToBeEdited.setDate(expense.getDate());

        if(bindingResult.hasErrors()) {
            return "expense-edit";
        }
        expenseService.updateExpense(expenseToBeEdited);
        return "redirect:/expense-list";
    }
}
