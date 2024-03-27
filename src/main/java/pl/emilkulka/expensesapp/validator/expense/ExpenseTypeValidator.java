package pl.emilkulka.expensesapp.validator.expense;

import pl.emilkulka.expensesapp.model.ExpenseType;
import pl.emilkulka.expensesapp.validator.FieldValidator;

import java.util.Arrays;
import java.util.List;

public class ExpenseTypeValidator implements FieldValidator<ExpenseType> {
    public boolean isValid(ExpenseType expenseType) {
        List<ExpenseType> choices = Arrays.asList(ExpenseType.values());

        return !choices.contains(expenseType);
    }
}
