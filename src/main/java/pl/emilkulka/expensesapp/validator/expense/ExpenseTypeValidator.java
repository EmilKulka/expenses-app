package pl.emilkulka.expensesapp.validator.expense;

import org.springframework.stereotype.Component;
import pl.emilkulka.expensesapp.model.ExpenseType;
import pl.emilkulka.expensesapp.validator.FieldValidator;

import java.util.Arrays;
import java.util.List;
@Component
public class ExpenseTypeValidator implements FieldValidator<ExpenseType> {
    public boolean isValid(ExpenseType expenseType) {
        List<ExpenseType> choices = Arrays.asList(ExpenseType.values());

        return !choices.contains(expenseType);
    }
}
