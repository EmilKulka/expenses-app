package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.exception.expense.DescriptionLimitException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class validExpenseDescriptionTest {

    @Test
    void setDescriptionShouldWorkCorrectly() {
        Expense expense = new Expense();

        expense.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Vivamus pulvinar gravida lorem sed posuere.");

        assertEquals(100,expense.getDescription().length());
    }

    }



