package pl.emilkulka.expensesapp.ExpenseTest;

import models.Expense;
import org.junit.jupiter.api.Test;
import enums.ExpenseTypes;

import java.math.BigDecimal;
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
