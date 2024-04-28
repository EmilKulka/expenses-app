package pl.emilkulka.expensesapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.repository.UserRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;
import pl.emilkulka.expensesapp.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/expense-list")
public class ExpenseListController {

    private final ExpenseService expenseService;
    private final UserService userService;


    @GetMapping()
    private String expenseList(Model model, Principal principal) {
         /*
    Retrieving the logged-in user username -> searching for the user in the database by username -> getting users list of expenses
    */
        String user = principal.getName();
        List<Expense> userExpenses = userService.findByUsername(user).getExpenseList();

        model.addAttribute("expenses", userExpenses);
        return "expense-list";
    }

    @PostMapping("/delete")
    private String deleteById(Long id) {
        expenseService.deleteById(id);
        return "redirect:/api/expense-list";
    }

    @GetMapping("/update/{id}")
    public String editExpense(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "expense-edit";
    }

    @PostMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") @Valid Expense expense, BindingResult bindingResult) {
        Expense expenseToBeEdited = expenseService.getExpenseById(id);

        expenseToBeEdited.setId(id);
        expenseToBeEdited.setType(expense.getType());
        expenseToBeEdited.setDescription(expense.getDescription());
        expenseToBeEdited.setPrice(expense.getPrice());
        expenseToBeEdited.setDate(expense.getDate());

        if (bindingResult.hasErrors()) {
            return "expense-edit";
        }

        expenseService.updateExpense(expenseToBeEdited);
        return "redirect:/api/expense-list";
    }
}
