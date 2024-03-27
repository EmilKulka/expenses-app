package pl.emilkulka.expensesapp.validator.expense;

import pl.emilkulka.expensesapp.validator.FieldValidator;

public class DescriptionValidator implements FieldValidator<String> {
    public boolean isValid(String description) {
        return description.length() > 100;
    }
}
