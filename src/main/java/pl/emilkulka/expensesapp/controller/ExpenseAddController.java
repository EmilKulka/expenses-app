package pl.emilkulka.expensesapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.emilkulka.expensesapp.model.AppUser;
import pl.emilkulka.expensesapp.model.Expense;
import pl.emilkulka.expensesapp.service.ExpenseService;
import pl.emilkulka.expensesapp.service.UserService;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/api/expense-add")
public class ExpenseAddController {

    private final ExpenseService expenseService;
    private final UserService userService;

    @GetMapping()
    private String addExpense(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense-add";
    }

    @PostMapping
    private String saveExpense(@Valid Expense expense, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "expense-add";
        }

        /*
    Retrieving the logged-in user's username -> searching for the user in the database by username -> setting the user ID in the expense
    */
        String userName = principal.getName();
        AppUser appUser = userService.findByUsername(userName);
        expense.setUser(appUser);

        expenseService.saveExpense(expense);
        return "redirect:/api/expense-add";
    }
}
