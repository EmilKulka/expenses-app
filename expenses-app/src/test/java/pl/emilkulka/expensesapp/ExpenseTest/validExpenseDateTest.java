package pl.emilkulka.expensesapp.ExpenseTest;

import exceptions.DateFromFutureException;
import models.Expense;
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
        try {
            expense.setDate(LocalDate.of(2024,3,10));
            fail("Should throw exception");
        }catch (DateFromFutureException e) {
            assertTrue(true);
        }
    }
}

