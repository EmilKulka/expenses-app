package pl.emilkulka.expensesapp.validator.expense;

import org.springframework.stereotype.Component;
import pl.emilkulka.expensesapp.validator.FieldValidator;

import java.math.BigDecimal;
@Component
public class PriceValidator implements FieldValidator<BigDecimal> {
    public boolean isValid(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) < 0;
    }
}
