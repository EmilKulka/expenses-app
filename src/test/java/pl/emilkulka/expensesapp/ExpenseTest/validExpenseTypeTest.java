package pl.emilkulka.expensesapp.ExpenseTest;

import pl.emilkulka.expensesapp.exception.expense.InvalidTypeException;
import pl.emilkulka.expensesapp.model.Expense;
import org.junit.jupiter.api.Test;
import pl.emilkulka.expensesapp.model.ExpenseType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class validExpenseTypeTest {

    @Test
    void setTypeShouldWorkCorrectly() {
        Expense expense = new Expense();
        ExpenseType expectedType = ExpenseType.GROCERIESANDCHEMICALS;

        expense.setType(expectedType);

        assertEquals(expectedType, expense.getType());
    }

}
