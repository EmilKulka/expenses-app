package pl.emilkulka.expensesapp.validator.expense;

import pl.emilkulka.expensesapp.validator.FieldValidator;

import java.math.BigDecimal;

public class PriceValidator implements FieldValidator<BigDecimal> {
    public boolean isValid(BigDecimal price) {
        return price.compareTo(BigDecimal.ZERO) < 0;
    }
}
