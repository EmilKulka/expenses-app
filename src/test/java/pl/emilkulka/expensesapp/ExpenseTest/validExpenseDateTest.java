package pl.emilkulka.expensesapp.ExpenseTest;

import org.springframework.cglib.core.Local;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.ExpenseType;
import pl.emilkulka.expensesapp.repository.ExpenseRepository;
import pl.emilkulka.expensesapp.service.ExpenseService;
import pl.emilkulka.expensesapp.validator.expense.DateValidator;
import pl.emilkulka.expensesapp.validator.expense.DescriptionValidator;
import pl.emilkulka.expensesapp.validator.expense.ExpenseTypeValidator;
import pl.emilkulka.expensesapp.validator.expense.PriceValidator;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public class validExpenseDateTest {


    @Test
    void setDateShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setDate(LocalDate.of(2024, 2, 2));

        assertEquals(LocalDate.of(2024,2,2), expense.getDate());
    }

}

