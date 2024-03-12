package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.enums.ExpenseTypes;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class validExpenseTypeTest {

    @Test
    void isExpenseTypeValid() {
        Expense expense = new Expense();

        expense.setType(ExpenseTypes.valueOf("GROCERIESANDCHEMICALS"));
        List<ExpenseTypes> choices = Arrays.asList(ExpenseTypes.values());

        assertTrue(choices.contains(expense.getType()));
    }
}
