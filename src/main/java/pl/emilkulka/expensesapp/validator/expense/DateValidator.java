package pl.emilkulka.expensesapp.validator.expense;

import org.springframework.stereotype.Component;
import pl.emilkulka.expensesapp.validator.FieldValidator;

import java.time.LocalDate;
@Component
public class DateValidator implements FieldValidator<LocalDate> {
    @Override
    public boolean isValid(LocalDate date) {
        LocalDate localDate = LocalDate.now();
        return date.isAfter(localDate);
    }
}
