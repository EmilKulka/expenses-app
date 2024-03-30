package pl.emilkulka.expensesapp.validator.expense;

import org.springframework.stereotype.Component;
import pl.emilkulka.expensesapp.validator.FieldValidator;
@Component
public class DescriptionValidator implements FieldValidator<String> {
    public boolean isValid(String description) {
        return description.length() > 100;
    }
}
