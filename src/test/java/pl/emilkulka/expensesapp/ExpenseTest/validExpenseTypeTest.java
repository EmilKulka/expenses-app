package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.ExpenseType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class validExpenseTypeTest {

    @Test
    void isExpenseTypeValid() {
        Expense expense = new Expense();

        expense.setType(ExpenseType.valueOf("GROCERIESANDCHEMICALS"));
        List<ExpenseType> choices = Arrays.asList(ExpenseType.values());

        assertTrue(choices.contains(expense.getType()));
    }
}
