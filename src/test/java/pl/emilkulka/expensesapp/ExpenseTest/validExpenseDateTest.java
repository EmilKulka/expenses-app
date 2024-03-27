package pl.emilkulka.expensesapp.ExpenseTest;

import org.springframework.cglib.core.Local;
import pl.emilkulka.expensesapp.exception.expense.DateFromFutureException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

public class validExpenseDateTest {

    @Test
    void setDateShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setDate(LocalDate.of(2024, 2, 2));

        assertEquals(LocalDate.of(2024,2,2), expense.getDate());
    }

    @Test
    void itDenyDateFromFuture() {
        Expense expense = new Expense();

        assertThrows(DateFromFutureException.class,
                () -> expense.setDate(LocalDate.now().plusDays(1)));
    }
}

