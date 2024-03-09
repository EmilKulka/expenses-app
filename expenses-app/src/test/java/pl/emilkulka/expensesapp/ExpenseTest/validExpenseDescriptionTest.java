package pl.emilkulka.expensesapp.ExpenseTest;

import exceptions.DescriptionLimitException;
import models.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class validExpenseDescriptionTest {

    @Test
    void isDescriptionValid() {
        Expense expense = new Expense();

        expense.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vivamus pulvinar gravida lorem sed posuere.");

        assertEquals(100,expense.getDescription().length());
    }


    @Test
    void itDenyInvalidDescription() {
        Expense expense = new Expense();

        try {
            expense.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Vivamus pulvinar gravida lorem sed posuere. Vivamus pulvinar gravida lorem sed posuere.");
            fail("Exception should be raised.");
        }catch (DescriptionLimitException e) {
            assertTrue(true);
        }
    }


}
