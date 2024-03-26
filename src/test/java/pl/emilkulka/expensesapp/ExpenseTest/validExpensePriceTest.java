package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.exception.NegativePriceException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.math.BigDecimal;

public class validExpensePriceTest {

    @Test
    void isPriceValid() {
        Expense expense = new Expense();

        expense.setPrice(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(100), expense.getPrice());
    }

    @Test
    void itDenyInvalidPrice() {
        Expense expense = new Expense();

        assertThrows(NegativePriceException.class,
                () -> expense.setPrice(BigDecimal.valueOf(-100)));
    }
}