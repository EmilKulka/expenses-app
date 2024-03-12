package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.exception.DateFromFutureException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;

public class validExpenseDateTest {

    @Test
    void isDateValid() {
        Expense expense = new Expense();

        expense.setDate(LocalDate.of(2024, 2, 2));

        assertEquals(new Date(2024,2,2), expense.getDate());
    }

    @Test
    void itDenyDateFromFuture() {
        Expense expense = new Expense();

        assertThrows(DateFromFutureException.class,
                () -> expense.setDate(LocalDate.of(2024,3,12)));
    }
}

